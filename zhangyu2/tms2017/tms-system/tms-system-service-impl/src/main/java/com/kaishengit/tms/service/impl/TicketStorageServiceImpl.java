package com.kaishengit.tms.service.impl;


import com.alibaba.dubbo.config.annotation.Service;
import com.kaishengit.tms.entity.Ticket;
import com.kaishengit.tms.entity.TicketExample;
import com.kaishengit.tms.mapper.TicketMapper;
import com.kaishengit.tms.service.TicketStorageService;
import com.kaishengit.tms.service.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class TicketStorageServiceImpl implements TicketStorageService {

    //定义格式化年票编号的常量 自定义为6位编号
    private static final String STR_FORMAT = "000000";

    @Autowired
    private TicketMapper ticketMapper;

    /**
     * 年票入库
     *
     * @param ticketNumStart
     * @param ticketNumEnd
     * @param ticketInTime
     * @param invalidNum
     */
    @Override
    @Transactional
    public void inStorage(String ticketNumStart, Integer ticketNumEnd, String ticketInTime,
                          String invalidNum,String ticketInTotal) {
        Integer intTicketNumStart = Integer.parseInt(ticketNumStart);
        Integer intTicketInTotal = Integer.parseInt(ticketInTotal);
        ticketNumEnd = intTicketNumStart + intTicketInTotal - 1;
        Integer total = ticketNumEnd - intTicketNumStart;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        for (int i = 0; i <= total; i++) {
            Ticket ticket = new Ticket();
            ticket.setTicketInTime(new Date());
            ticket.setTicketNum(ticketNumStart);
            ticket.setTicketState("0");
            intTicketNumStart++;
            DecimalFormat df = new DecimalFormat(STR_FORMAT);
            ticket.setTicketNum(df.format(intTicketNumStart - 1));
            ticketMapper.insertSelective(ticket);
        }

        //对invalidNum 进行截取
        if (invalidNum != null && !invalidNum.isEmpty()) {
            String[] invalidArrays = invalidNum.split(",");
            for (String num : invalidArrays) {
                DecimalFormat df = new DecimalFormat(STR_FORMAT);
                String numFormat = df.format(Integer.parseInt(num));
                Ticket ticket = findTicketByTicketNum(numFormat);
                if (ticket != null) {
                    ticket.setTicketState("2");
                    //修改数据库
                    ticketMapper.updateByPrimaryKeySelective(ticket);
                }
            }
        }
    }

    /**
     * 年票下发
     *
     * @param ticketNumStart
     * @param ticketNumEnd
     * @param storeAccountId
     */
    @Override
    @Transactional
    public void outStorage(String ticketNumStart, Integer ticketNumEnd,
                           Integer storeAccountId,String ticketOutTotal) {
        Integer intTicketOutTotal = Integer.parseInt(ticketOutTotal);
        Integer intTicketNumStart = Integer.parseInt(ticketNumStart);
        ticketNumEnd = intTicketNumStart + intTicketOutTotal - 1;
        Integer total = ticketNumEnd - intTicketNumStart;

        for (int i = 0; i <= total; i++) {
            DecimalFormat df = new DecimalFormat(STR_FORMAT);
            try {
                Ticket ticket = findTicketByTicketNum(df.format(intTicketNumStart));
                System.out.println(">>>>>>>>>" + df.format(intTicketNumStart));
                if ("0".equals(ticket.getTicketState())) {
                    ticket.setStoreAccountId(storeAccountId);
                    ticket.setTicketState("1");
                    ticket.setTicketOutTime(new Date());
                    intTicketNumStart++;
                    ticketMapper.updateByPrimaryKeySelective(ticket);
                }
                if ("2".equals(ticket.getTicketState())) {
                    intTicketNumStart++;
                    total++;
                    System.out.println("<<<<<<<<<" + intTicketNumStart);
                }
            }catch (NullPointerException ex) {
                throw new NullPointerException("年票编号不存在！");
            }

        }


    }
    /**
     * 年票作废
     * @param storeAccountId
     * @param invalidNum
     */
    @Override
    @Transactional
    public void invalidTicket(Integer storeAccountId, String invalidNum) {
        if (invalidNum != null && !invalidNum.isEmpty()) {
            String[] invalidArrays = invalidNum.split(",");
            for (String num : invalidArrays) {
                DecimalFormat df = new DecimalFormat(STR_FORMAT);
                String numFormat = df.format(Integer.parseInt(num));
                Ticket ticket = findTicketByTicketNumAndStoreAccountId(numFormat,storeAccountId);
                if (ticket == null) {
                    throw new ServiceException("该售票点不存在此年票!");
                }
                ticket.setTicketState("2");
                ticketMapper.updateByPrimaryKeySelective(ticket);
            }
        }
    }

    /**
     * 查找年票入库数量
     */
    @Override
    public Long findTotalTicketIn() {
        return ticketMapper.countByExample(new TicketExample());
    }
    /**
     * 查找年票下发数量
     * @return
     */
    @Override
    public Long findTotalTicketOut() {
        TicketExample example = new TicketExample();
        example.createCriteria().andTicketStateEqualTo("1");
        return ticketMapper.countByExample(example);
    }
    /**
     * 查找年票作废数量
     * @return
     */
    @Override
    public Long findTotalInvalidTicket() {
        TicketExample example = new TicketExample();
        example.createCriteria().andTicketStateEqualTo("2");
        return ticketMapper.countByExample(example);
    }
    /**
     * 库存量
     * @return
     */
    @Override
    public Long findTicketStorage() {
        TicketExample example = new TicketExample();
        example.createCriteria().andTicketStateEqualTo("0");
        return ticketMapper.countByExample(example);
    }
    /**
     * 从数据库中查出id最大的ticket
     * @return
     */
    @Override
    public Ticket findMaxIdTicket() {
        return ticketMapper.findMaxIdTicket();
    }

    /**
     * 查找当前数据库中已下发的最小编号
     * @return
     */
    @Override
    public Ticket findTicketOutWithIdMin() {
        return ticketMapper.findTicketOutWithIdMin();
    }


    /**
     * 根据年票编号与售票点id查询年票
     * @param ticketNum
     * @param storeAccountId
     * @return
     */
    public Ticket findTicketByTicketNumAndStoreAccountId(String ticketNum,Integer storeAccountId) {
        Ticket ticket = findTicketByTicketNum(ticketNum);
        if (ticket != null && ticket.getStoreAccountId() == storeAccountId) {
            return ticket;
        }
        return null;
    }


    /**
     * 根据年票编号查找年票信息
     *
     * @param ticketNum
     * @return
     */
    public Ticket findTicketByTicketNum(String ticketNum) {
        TicketExample ticketExample = new TicketExample();
        ticketExample.createCriteria().andTicketNumEqualTo(ticketNum);
        List<Ticket> tickets = ticketMapper.selectByExample(ticketExample);
        Ticket ticket = null;
        if (tickets != null && !tickets.isEmpty()) {
            ticket = tickets.get(0);
        }
        return ticket;
    }


}

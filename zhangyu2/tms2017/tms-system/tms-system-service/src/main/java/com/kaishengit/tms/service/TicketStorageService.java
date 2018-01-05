package com.kaishengit.tms.service;

import com.kaishengit.tms.entity.Ticket;

import java.util.List;

public interface TicketStorageService {

    /**
     * 年票入库
     * @param ticketNumStart
     * @param ticketNumEnd
     * @param ticketInTime
     * @param invalidNum
     */
    void inStorage(String ticketNumStart,Integer ticketNumEnd, String ticketInTime, String invalidNum,String ticketInTotal);

    /**
     * 年票下发
     * @param ticketNumStart
     * @param ticketNumEnd
     * @param storeAccountId
     */
    void outStorage(String ticketNumStart, Integer ticketNumEnd,Integer storeAccountId,String ticketOutTotal);

    /**
     * 年票作废
     * @param storeAccountId
     * @param invalidNum
     */
    void invalidTicket(Integer storeAccountId, String invalidNum);

    /**
     * 查找年票入库数量
     */
    Long findTotalTicketIn();

    /**
     * 查找年票下发数量
     * @return
     */
    Long findTotalTicketOut();
    /**
     * 查找年票作废数量
     * @return
     */
    Long findTotalInvalidTicket();

    /**
     * 库存量
     * @return
     */
    Long findTicketStorage();

    /**
     * 从数据库中查出id最大的ticket
     * @return
     */
    Ticket findMaxIdTicket();

    /**
     * 查找当前数据库中已下发的最小编号
     * @return
     */
    Ticket findTicketOutWithIdMin();
}

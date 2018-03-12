package com.niurenpai.constant.dto;

import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.Date;

@Data
@ToString
public class UserPlanStatus {

    private Date guessStartTime;

    private Date guessEndTime;

    private Date auctionEndTime;

    private int planStatus;

    private int userGuessStatus;

    private int userAuctionStatus;

    private BigDecimal userGuessAmount;

    private BigDecimal userAuctionAmount;

}

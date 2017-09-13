package com.niurenpai.service.impl;

import com.niurenpai.mapper.dao.*;
import com.niurenpai.service.CoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author meng.haoran
 * @create 2017/9/13 20:51
 */
@Service("coreService")
public class CoreServiceImpl implements CoreService{
    @Autowired
    AuctionPlanMapper auctionPlanMapper;
    @Autowired
    AuctionRecordMapper auctionRecordMapper;
    @Autowired
    GuessRecordMapper guessRecordMapper;
    @Autowired
    InterviewMapper interviewMapper;
    @Autowired
    MoneyRecordMapper moneyRecordMapper;
    @Autowired
    NiuRenMapper niuRenMapper;
    @Autowired
    UserAccountMapper userAccountMapper;
    @Autowired
    UserMapper userMapper;

}

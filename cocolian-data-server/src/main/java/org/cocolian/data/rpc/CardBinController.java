package org.cocolian.data.rpc;


import org.cocolian.data.CardBin;
import org.cocolian.data.rpc.DataRpcService.CardBinRequest;
import org.cocolian.data.rpc.DataRpcService.CardBinResponse;
import org.cocolian.data.server.repository.CardBinRepository;
import org.cocolian.metric.Timer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.cocolian.rpc.NotFoundException;
import org.cocolian.rpc.SystemException;
import org.cocolian.rpc.UserException;
import org.cocolian.rpc.server.Controller;

import java.util.List;

/**
 * 
 * @author shamphone@gmail.com
 * @version 1.0.0
 * @date 2017年8月22日
 */
@Component("cardBin")
public class CardBinController implements Controller<CardBinRequest, CardBinResponse> {
	private static final Logger logger = LoggerFactory.getLogger(CardBinController.class);

	@Autowired
	private CardBinRepository cardBinRepository;

	@Override
	@Timer("cardBin")
	public CardBinResponse process(CardBinRequest request)
			throws NotFoundException, SystemException, UserException {
		logger.info("get card bin");
		CardBinResponse.Builder response = CardBinResponse.newBuilder();
		List<CardBin> cardBinList = cardBinRepository.getAllCardBin();
		if(null == cardBinList || cardBinList.isEmpty()){
			logger.error("CardBin data is empty.");
			throw new NotFoundException();
		}
		logger.info("get card bin records: "+cardBinList.size());
		return response.addAllCardBin(cardBinList).build();
	}

}

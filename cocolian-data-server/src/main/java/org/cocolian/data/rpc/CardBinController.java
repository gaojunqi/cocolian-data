package org.cocolian.data.rpc;


import org.cocolian.data.CardBin;
import org.cocolian.data.rpc.DataService.CardBinRequest;
import org.cocolian.data.rpc.DataService.CardBinResponse;
import org.cocolian.metric.Timer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.cocolian.rpc.NotFoundException;
import org.cocolian.rpc.SystemException;
import org.cocolian.rpc.UserException;
import org.cocolian.rpc.server.Controller;

/**
 * 
 * @author shamphone@gmail.com
 * @version 1.0.0
 * @date 2017年8月22日
 */
@Component("cardBin")
public class CardBinController implements Controller<CardBinRequest, CardBinResponse> {
	private static final Logger logger = LoggerFactory.getLogger(CardBinController.class);

	@Override
	@Timer("cardBin")
	public CardBinResponse process(CardBinRequest request)
			throws NotFoundException, SystemException, UserException {
		//TODO: 这里是测试代码，需要修改为从MySQL数据库中读取数据。 
		logger.info("get card bin");
		CardBin.Builder item =CardBin.newBuilder();
		item.setIssuerCode("1001");
		item.setIssuerName("TestIssuer");
		CardBinResponse.Builder response = CardBinResponse.newBuilder();
		response.addCardBin(item.build());
		return response.build();
	}

}

/**
 * 
 */
package org.cocolian.data;

import java.util.List;

import org.cocolian.data.rpc.DataService.CardBinRequest;
import org.cocolian.data.rpc.DataService.CardBinResponse;
import org.cocolian.rpc.sharder.RpcServiceClient;

/**
 * 卡bin库
 * @author <a mailto="shamphone@gmail.com">Shamphone Lee</a> 
 *
 */
public class DataService {

	private static final String CARD_BIN_SERVICE_NAME = "cardBin";

	private RpcServiceClient client;
	private String rpcUserName;
	private String rpcPassword;
	
	public DataService(RpcServiceClient client, String rpcUserName, String rpcPassword){
		this.client = client;
		this.rpcPassword = rpcPassword;
		this.rpcUserName = rpcUserName;
	}
	
	
	public List<CardBin> getCardBins(){
		CardBinRequest.Builder request = CardBinRequest.newBuilder();
		request.setUserName(rpcUserName);
		request.setPassword(rpcPassword);
		CardBinResponse response = client.execute(CARD_BIN_SERVICE_NAME, request.build(), CardBinResponse.class);
		return response.getCardBinList();
	}
}

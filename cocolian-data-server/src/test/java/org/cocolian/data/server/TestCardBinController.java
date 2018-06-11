/**
 * 
 */
package org.cocolian.data.server;

import static org.junit.Assert.assertEquals;

import org.cocolian.data.rpc.CardBinController;
import org.cocolian.data.rpc.DataRpcService.CardBinRequest;
import org.cocolian.data.rpc.DataRpcService.CardBinResponse;
import org.cocolian.data.server.repository.CardBinRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author admin
 *
 */

@RunWith(SpringRunner.class)
@ActiveProfiles("dev")
@EnableAutoConfiguration
@SpringBootTest(classes = {DataServerConfiguration.class,TestConfiguration.class,
		DatabaseConfiguration.class,CardBinRepository.class}, webEnvironment = WebEnvironment.NONE)
public class TestCardBinController {

	@Autowired
	private CardBinController controller;
	
	/**
	 * 测试正常情况下的执行结果
	 * @throws Exception
	 */
	@Test
	public void testNormal() throws Exception {
		CardBinRequest.Builder request = CardBinRequest.newBuilder();
		request.setUserName("test");
		request.setPassword("password");
		CardBinResponse response = controller.process(request.build());
		assertEquals(response.getCardBinCount(),4856 );
	}
}

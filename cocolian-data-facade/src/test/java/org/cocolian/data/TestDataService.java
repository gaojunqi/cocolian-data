/**
 * 
 */
package org.cocolian.data;


import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author admin
 *
 */
@RunWith(SpringRunner.class)
@ActiveProfiles("dev")
@SpringBootTest(classes = DataConfiguration.class, webEnvironment = WebEnvironment.NONE)
public class TestDataService {

	@Autowired
	private DataService service;
	
	@Test
	public void testGetCardBin(){
		assertEquals(service.getCardBins().size(), 4856);
	}
}

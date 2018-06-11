package org.cocolian.data.server.repository;

import org.cocolian.data.CardBin;
import org.cocolian.mysql.JdbcProtobufTemplate;
import org.cocolian.rpc.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;


/**
 * @author qiaiduo@163.com
 * @version 1.0.0
 * @date 2018-06-10
 */
@Service
public class CardBinRepository  {

    private static final Logger logger = LoggerFactory.getLogger(CardBinRepository.class);

    private JdbcProtobufTemplate jdbcProtobufTemplate;

    @Autowired
    public CardBinRepository(JdbcTemplate jdbcTemplate) {
        jdbcProtobufTemplate = new JdbcProtobufTemplate<CardBin>(jdbcTemplate,CardBin.class);
    }
    @Transactional(readOnly = true)
    public List<CardBin>  getAllCardBin() throws NotFoundException {
        try{
            return jdbcProtobufTemplate.query("SELECT * FROM cardbin_t");
        }catch (Exception e){
            logger.error(e.getMessage());
            throw new NotFoundException();
        }
    }



}

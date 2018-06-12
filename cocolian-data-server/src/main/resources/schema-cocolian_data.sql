/*
SQLyog Enterprise v12.09 (64 bit)
MySQL - 5.6.10 : Database - cocolian_data
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`cocolian_data` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `cocolian_data`;

/*Table structure for table `cardbin_t` */

DROP TABLE IF EXISTS `cardbin_t`;

CREATE TABLE `cardbin_t` (
  `issuer_name` varchar(100) DEFAULT NULL COMMENT '发卡行名称',
  `issuer_code` varchar(20) DEFAULT NULL COMMENT '发卡机构代码',
  `card_name` varchar(100) DEFAULT NULL COMMENT '卡名',
  `atm_available` tinyint(1) DEFAULT NULL COMMENT 'ATM可用',
  `pos_available` tinyint(1) DEFAULT NULL COMMENT 'POS可用',
  `track_no` int(11) DEFAULT NULL COMMENT '磁道',
  `track_start_position` int(11) DEFAULT NULL COMMENT '磁道起始字节',
  `track_length` int(11) DEFAULT NULL COMMENT '磁道长度',
  `account_start_position` int(11) DEFAULT NULL COMMENT '主账号起始字节',
  `account_length` int(11) DEFAULT NULL COMMENT '主账号道长度',
  `account_no` varchar(32) DEFAULT NULL COMMENT '主账号',
  `account_track_no` int(11) DEFAULT NULL COMMENT '主账号信息所在磁道',
  `issuer_start_position` int(11) DEFAULT NULL COMMENT '发卡行起始字节',
  `issuer_length` int(11) DEFAULT NULL COMMENT '发卡行磁道长度',
  `issuer_no` bigint(11) DEFAULT NULL COMMENT '发卡行标识',
  `issuer_track_no` int(11) DEFAULT NULL COMMENT '发卡行信息所在磁道',
  `card_type` int(11) DEFAULT NULL COMMENT '卡种(枚举0:UNKNOWN_CARD_TYPE ,1:DEBIT_CARD,2:CREDIT_CARD,3:PREPAID_CARD)',
  `create_date` timestamp NULL DEFAULT NULL COMMENT '创建时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

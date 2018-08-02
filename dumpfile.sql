-- MySQL dump 10.16  Distrib 10.2.16-MariaDB, for Linux (x86_64)
--
-- Host: localhost    Database: newsreader_db
-- ------------------------------------------------------
-- Server version	10.2.16-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `news`
--

DROP TABLE IF EXISTS `news`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `news` (
  `news_id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(200) NOT NULL,
  `description` text DEFAULT NULL,
  `url` varchar(255) NOT NULL,
  `publishedAt` bigint(20) NOT NULL,
  PRIMARY KEY (`news_id`),
  UNIQUE KEY `url` (`url`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `news`
--

LOCK TABLES `news` WRITE;
/*!40000 ALTER TABLE `news` DISABLE KEYS */;
INSERT INTO `news` VALUES (1,'CBS Says Q2 Profit Rises, But Keeps Mum on Moonves Questions','CBS Corp. turned in record-high revenue and profits for the second quarter of 2018,  but declined to address continuing uncertainty over the fate of its CEO, Leslie Moonves. The company reported re…','https://variety.com/2018/biz/news/cbs-q2-2018-earnings-leslie-moonves-1202893665/',1533259583),(2,'Apple makes history by becoming first US company to reach $1 trillion market value','The iPhone maker has done what no U.S. company has done before: achieve a market value of $1 trillion.','https://www.usatoday.com/story/money/2018/08/02/apple-first-stock-hit-1-trillion-market-value/877867002/',1533259525),(3,'Why Sonos thinks its hardware IPO will be different','It’s no secret that hardware companies haven’t had much success in the IPO market as of late, but Sonos Inc. thinks it can break from the mold.','https://www.marketwatch.com/story/why-sonos-thinks-its-hardware-ipo-will-be-different-2018-08-02',1533256217),(4,'Elon Musk\'s apology was worth more than $8 billion to Tesla shareholders—but questions linger','Tesla Inc.’s Wednesday earnings call lacked the drama and hostility of the prior one, and that was exactly what investors wanted.','https://www.marketwatch.com/story/tesla-stock-soars-after-most-valuable-apology-of-all-time-but-profitability-questions-remain-2018-08-02',1533255960),(5,'AIG\'s Income Slid in Second Quarter','The insurer posted a 17% decline in second-quarter net income, weighed down by a $200 million pretax restructuring charge.','https://www.wsj.com/articles/aigs-income-slides-in-second-quarter-1533241002',1533255360),(6,'Costco becomes fight club as senior citizens brawl over free cheese samples','GREENVILLE, S.C. — Free samples briefly turned a Costco warehouse club into a fight club for two senior citizens.\r\n\nThe State newspaper in Columbia, South Carolina, cites a July 26 Greenville police report saying it began when a 72-year-old man cut ahead of a…','https://fox6now.com/2018/08/02/costco-becomes-fight-club-as-senior-citizens-brawl-over-free-cheese-samples/',1533254340),(7,'MoviePass wants you to know it is \'still standing\'','MoviePass hasn’t had a great couple of weeks week. But the company isn’t worried – and it wants everyone to know that.','https://www.usatoday.com/story/money/2018/08/02/moviepass-says-its-still-standing-amid-questions-business/891569002/',1533251700),(8,'Pizza Hut can\'t cash in on Papa John\'s problems','Yum Brands just reported weak sales for Pizza Hut. Can Pizza Hut, which took over the NFL sponsorship deal from Papa John\'s mount a comeback once football season starts? The bigger challenge may be toppling Domino\'s.','https://money.cnn.com/2018/08/02/investing/yum-pizza-hut-earnings-papa-johns/index.html',1533251340),(9,'MoviePass vs. AMC Stubs A-List vs. Movie Club vs. Sinemia: Movie subscriptions compared','Each subscription promises cheaper access to the cineplex. Is there one that\'s worth the money?','https://www.cnet.com/how-to/moviepass-amc-stubs-a-list-movie-club-sinemia-movie-theater-subscription-services-compared/',1533249945),(10,'The Trump administration is headed for a gigantic debt headache','Swelling government debt levels are shaping up to be the biggest economic challenge for President Donald Trump, a problem that could spill into the stock market.','https://www.cnbc.com/2018/08/02/the-trump-administration-is-headed-for-a-gigantic-debt-headache.html',1533249673),(11,'Apple-fueled tech rally lifts stock indexes','U.S. stocks end a rocky session decidedly higher on the back of a record rally by Apple that took the iPhone maker to a market cap above $1 trillion, a runup that helped Wall Street set aside nettlesome trade issues between the U.S. and China.','https://www.marketwatch.com/story/us-stock-benchmarks-poised-to-slump-as-trade-angst-rattles-global-markets-2018-08-02',1533249060),(12,'Utility Apologizes After System Gave Black Woman Temporary Password With \'N***a\' In It','Puget Sound Energy said it is taking steps to eliminate the chance any offensive words are randomly generated in the future.','https://www.huffingtonpost.com/entry/erica-conway-password-racial-slur_us_5b632302e4b0fd5c73d73384',1533246299),(13,'Amazon Prime Video is coming to Comcast\'s cable boxes','Comcast and Amazon today announced a new partnership that will see Amazon’s Prime Video service integrated into Comcast’s Xfinity TV set-top boxes. This is the first time that Prime Video content would be added to a cable operator’s platform in the U.S.. It’s…','https://techcrunch.com/2018/08/02/amazon-prime-video-is-coming-to-comcasts-cable-boxes/',1533244597),(14,'FCA recalls more than 1.1M newer RAM trucks due to risk tailgate could fly open','This wide-ranging recall for one of the best-selling vehicles in the world continues an unfortunate trend for FCA in 2018, as it already led all automakers for recalls through the first half of the year.','http://www.mlive.com/auto/index.ssf/2018/08/massive_fcaram_recall.html',1533243240),(15,'Brookstone files for bankruptcy and will close all of its mall stores','Brookstone is seeking a buyer for its 35 airport stores.','https://money.cnn.com/2018/08/02/news/companies/brookstone-bankruptcy/index.html',1533235802),(16,'Papa John\'s founder says he has \'no confidence\' in current management team, including CEO Steve Ritchie','Papa John\'s founder John Schnatter said he has \"no confidence\" in the current management team at the pizza chain, including the CEO he handpicked as his successor, after executives forced his ouster last month over some off-color remarks he made on a conferen…','https://www.cnbc.com/2018/08/02/papa-johns-founder-tells-cnbc-he-has-no-confidence-in-management-team.html',1533234658),(17,'GE employee charged with stealing company\'s trade secrets','Federal prosecutors say an engineer at General Electric\'s upstate New York turbine manufacturing plant has been charged with stealing the company\'s trade secrets.','http://www.wktv.com/content/news/GE-employee-charged-with-stealing-companys-trade-secrets-489878601.html',1533233040),(18,'\'You\'re getting nothing\': Steve Jobs\' daughter wrote a heartbreaking memoir about their often brutal relationship','Steve Jobs\' daughter Lisa Brennan-Jobs opened up about her relationship with her father in a heartbreaking excerpt published in Vanity Fair. The portrait is variously tender but also shows that the Apple cofounder and longtime CEO had a cruel side when it cam…','https://www.businessinsider.com/steve-jobs-daughter-lisa-book-small-fry-2018-8',1533230093),(19,'Cisco to acquire security unicorn Duo for $2.35 billion','Cisco Systems Inc. has agreed to pay $2.35 billion for security startup Duo Security, the companies announced Thursday morning, beefing up the networking company’s software offerings.','https://www.marketwatch.com/story/cisco-dances-with-duo-promises-235b-for-security-startup-2018-08-02',1533225205),(20,'Amazon forms US Postal Service lobby group with other companies','Amazon.com Inc and other retail and logistics companies said on Wednesday they had started a new group to lobby to keep the U.S. Postal Service\'s (USPS) package delivery services \"reliable and affordable.\"','https://www.reuters.com/article/us-usa-shippers-post-office/amazon-forms-u-s-postal-service-lobby-group-with-other-companies-idUSKBN1KM5X0',1533178773);
/*!40000 ALTER TABLE `news` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-08-02 18:30:07

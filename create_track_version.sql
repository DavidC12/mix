CREATE TABLE mixdbprd.`track_version` (
  `idtrack_version` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Default Counter',
  `create_timestamp` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_timestamp` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `create_user` varchar(60) NOT NULL DEFAULT 'SQL',
  `update_user` varchar(60) NOT NULL DEFAULT 'SQL',
  `artist_name` varchar(45) NOT NULL COMMENT 'Name of artist or band that would appear on the single cover',
  `song_name` varchar(45) NOT NULL COMMENT 'Name of song that would appear on the single cover',
  `remix_name` varchar(100) DEFAULT 'ALBUM' COMMENT 'Remix name if any.  If none this defaults to ALBUM as the type',
  `beat_mixable` tinyint(4) DEFAULT '0' COMMENT 'Set to 1 if the song has a lead-in and a steady unchanging beat.',
  `bpm_start` int(11) DEFAULT NULL,
  `bpm_end` int(11) DEFAULT NULL,
  `key_start` char(2) DEFAULT NULL,
  `key_end` char(2) DEFAULT NULL,
  `rating` int(11) DEFAULT NULL COMMENT 'track rating',
  `rating_date` date DEFAULT NULL COMMENT 'Date track last rated',
  `comment` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`idtrack_version`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='This table holds the low level information associated with each track to the remix level.  Track metadata, such as beginning and ending keys and bpm are kept here.';

select * from mixdb.track_version;
-- delete from mixdb.track_version where idtrack_version = 13;
insert into mixdb.track_version
(
	idtrack_version,
    create_timestamp,
    update_timestamp,
    create_user,
    update_user,
    artist_name,
    song_name,
    remix_name,
    beat_mixable,
    bpm_start,
    bpm_end,
    key_start,
    key_end,
    rating,
    rating_date,
    comment
) values
(
	1,
	current_timestamp,
    current_timestamp,
    'TEST',
    'TEST',
    'Bob',
    'Big Boy',
    'Extended',
    1,
    120,
    120,
    'E',
    'E#',
    3,
    current_date,
    'Welcome to the bobs bigboy remix'
);

SELECT idtrack_version,
    create_timestamp,
    update_timestamp,
    create_user,
    update_user,
    artist_name,
    song_name,
    remix_name,
    beat_mixable,
    bpm_start,
    bpm_end,
    key_start,
    key_end,
    comment,
    rating,
    rating_date
FROM mixdb.track_version;

-- delete from mixdb.track_version where idtrack_version > 1;
SELECT *
FROM `ride_tracker`.`ride`;

UPDATE `mixdb`.`track_version`
SET
`idtrack_version` = <{idtrack_version: }>,
`create_timestamp` = <{create_timestamp: CURRENT_TIMESTAMP}>,
`update_timestamp` = <{update_timestamp: CURRENT_TIMESTAMP}>,
`create_user` = <{create_user: SQL}>,
`update_user` = <{update_user: SQL}>,
`artist_name` = <{artist_name: }>,
`song_name` = <{song_name: }>,
`remix_name` = <{remix_name: ALBUM}>,
`beat_mixable` = <{beat_mixable: 0}>,
`bpm_start` = <{bpm_start: }>,
`bpm_end` = <{bpm_end: }>,
`key_start` = <{key_start: }>,
`key_end` = <{key_end: }>,
`rating` = <{rating: }>,
`rating_date` = <{rating_date: }>,
`comment` = <{comment: }>
WHERE `idtrack_version` = <{expr}>;

-- delete mixdb.track_version where idtrack_version > 7;
    
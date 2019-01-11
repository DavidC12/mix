select * from mixdb.track_version;
insert into mixdb.track_version
(
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
    comment
) values
(
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
    'Welcome to the bobs bigboy remix'
)

SELECT `track_version`.`idtrack_version`,
    `track_version`.`create_timestamp`,
    `track_version`.`update_timestamp`,
    `track_version`.`create_user`,
    `track_version`.`update_user`,
    `track_version`.`artist_name`,
    `track_version`.`song_name`,
    `track_version`.`remix_name`,
    `track_version`.`beat_mixable`,
    `track_version`.`bpm_start`,
    `track_version`.`bpm_end`,
    `track_version`.`key_start`,
    `track_version`.`key_end`,
    `track_version`.`comment`
FROM `mixdb`.`track_version`;

    
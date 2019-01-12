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
select * from mixdb.track_version;    
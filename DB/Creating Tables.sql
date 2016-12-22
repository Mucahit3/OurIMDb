CREATE DATABASE imdb;
USE imdb;

CREATE TABLE IF NOT EXISTS Movie(
    mTitle VARCHAR(255) NOT NULL,
    mDate VARCHAR(15) NOT NULL,
    mCountry VARCHAR(50) NOT NULL,
    mTime VARCHAR(10) NOT NULL,
    mLanguage VARCHAR(50) NOT NULL,
    mRatingSum INT DEFAULT 0,
    mRatingCount INT DEFAULT 0,
    mDescription TEXT,
    mImage longblob,
    mUrlLink VARCHAR(255),
    movieId VARCHAR(20) NOT NULL,
    PRIMARY KEY(movieId)
);

CREATE TABLE IF NOT EXISTS Genre(
	mType VARCHAR(50) NOT NULL,
    movieId VARCHAR(20),
    FOREIGN KEY (movieId) REFERENCES Movie(movieId) ON UPDATE CASCADE ON DELETE NO ACTION,
    PRIMARY KEY (movieId,mType)
);

CREATE TABLE IF NOT EXISTS People(
    pTitle VARCHAR(255) NOT NULL,
    pBirthday VARCHAR(15) NOT NULL,
    pBirthPlace VARCHAR(255) NOT NULL,
    pImage longblob,
    pDescription TEXT,
    pImageUrl VARCHAR(200),
    peopleId VARCHAR(20) NOT NULL,
    PRIMARY KEY(peopleId)
);

CREATE TABLE IF NOT EXISTS MoviePeople(
	fkMovieId VARCHAR(20),
    fkPeopleId VARCHAR(20),
    castName VARCHAR(255),
    actorFlag TINYINT(1) DEFAULT 0 CHECK(VALUE IN(0,1)),
    directorFlag TINYINT(1) DEFAULT 0 CHECK(VALUE IN(0,1)),
    writerFlag TINYINT(1) DEFAULT 0 CHECK(VALUE IN(0,1)),
    FOREIGN KEY (fkMovieId) REFERENCES Movie(movieId) ON UPDATE CASCADE ON DELETE NO ACTION,
    FOREIGN KEY (fkPeopleId) REFERENCES People(peopleId) ON UPDATE CASCADE ON DELETE NO ACTION,
	CONSTRAINT PRIMARY KEY (fkMovieId,fkPeopleId)
);

CREATE TABLE IF NOT EXISTS Organization(
	orgName VARCHAR(50) NOT NULL,
    orgCountry VARCHAR(50) NOT NULL,
	organizationId INT NOT NULL AUTO_INCREMENT,
    PRIMARY KEY (organizationId)
);

CREATE TABLE IF NOT EXISTS MovieAward(
	fkOrgId INT ,
    fkMovieId VARCHAR(20),
    movieAwardTitle VARCHAR(255) NOT NULL,
    movieAwardYear DATE NOT NULL,
    awardId INT NOT NULL AUTO_INCREMENT,
    FOREIGN KEY (fkOrgId) REFERENCES Organization(organizationId) ON UPDATE CASCADE ON DELETE NO ACTION,
    FOREIGN KEY (fkMovieId) REFERENCES Movie(movieId) ON UPDATE CASCADE ON DELETE NO ACTION,
    PRIMARY KEY(awardId)
);

CREATE TABLE IF NOT EXISTS PeopleAward(
	peopleAwardTitle VARCHAR(255) NOT NULL,
    peopleAwardYear DATE NOT NULL,
    awardId INT NOT NULL AUTO_INCREMENT,
    fkOrgId INT ,
    fkMovieId VARCHAR(20),
    FOREIGN KEY (fkOrgId) REFERENCES Organization(organizationId) ON UPDATE CASCADE ON DELETE NO ACTION,
    FOREIGN KEY (fkMovieId) REFERENCES Movie(movieId) ON UPDATE CASCADE ON DELETE NO ACTION,
    PRIMARY KEY(awardId)
);

CREATE TABLE IF NOT EXISTS Users(
	uEmail VARCHAR(80) NOT NULL,
    uDisplayName VARCHAR(50) NOT NULL,
    uPassword CHAR(40) NOT NULL,
    uRegistrationDate TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    uImage blob,
    userId INT NOT NULL AUTO_INCREMENT,
    PRIMARY KEY(userId)
);

CREATE TABLE IF NOT EXISTS MovieCommend(
	fkMovieId VARCHAR(20),
    fkUserId INT,
    commend VARCHAR(200) NOT NULL,
    commendId INT NOT NULL AUTO_INCREMENT,
    FOREIGN KEY (fkMovieId) REFERENCES Movie(movieId) ON UPDATE CASCADE ON DELETE SET NULL,
    FOREIGN KEY (fkUserId) REFERENCES Users(userId) ON UPDATE CASCADE ON DELETE SET NULL,
    PRIMARY KEY (commendId)
);
 
CREATE TABLE IF NOT EXISTS MovieReply(
	fkCommendId INT,
    fkUserId INT,
    commend VARCHAR(200) NOT NULL,
    commendId INT NOT NULL AUTO_INCREMENT,
    FOREIGN KEY (fkCommendId) REFERENCES MovieCommend(commendId) ON UPDATE CASCADE ON DELETE SET NULL,
    PRIMARY KEY(commendId)
);
ALTER TABLE MovieReply AUTO_INCREMENT = 1000000;
    
CREATE TABLE IF NOT EXISTS Rating(
	fkUserId INT,
    fkMovieId VARCHAR(20),
    rating INT NOT NULL,
    FOREIGN KEY (fkUserId) REFERENCES Users(userId) ON UPDATE CASCADE ON DELETE NO ACTION,
    FOREIGN KEY (fkMovieId) REFERENCES Movie(movieId) ON UPDATE CASCADE ON DELETE NO ACTION,
    PRIMARY KEY (fkUserId, fkMovieId)
);

CREATE TABLE IF NOT EXISTS WatchList(
	fkUserId INT,
    fkMovieId VARCHAR(20),
    FOREIGN KEY (fkUserId) REFERENCES Users(userId) ON UPDATE CASCADE ON DELETE NO ACTION,
    FOREIGN KEY (fkMovieId) REFERENCES Movie(movieId) ON UPDATE CASCADE ON DELETE NO ACTION,
    PRIMARY KEY (fkUserId,fkMovieId)
);


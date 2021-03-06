USE [master]
GO

CREATE DATABASE [test]
 ON  PRIMARY 
( NAME = N'test', FILENAME = N'D:\DB\MSSQL\test.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'test_log', FILENAME = N'D:\DB\MSSQL\test_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
GO


CREATE LOGIN [test] WITH PASSWORD=N'test', DEFAULT_DATABASE=[master], CHECK_EXPIRATION=OFF, CHECK_POLICY=OFF
GO
USE [test]
GO
CREATE USER [test] FOR LOGIN [test]
GO
USE [test]
GO
ALTER ROLE [db_owner] ADD MEMBER [test]
GO

CREATE TABLE [dbo].[SportItem](
	[id] [int] NOT NULL PRIMARY KEY,
	[name] [nvarchar](128) NOT NULL,
	[price] [decimal](8, 2) NOT NULL,
	[countInStock] [int] NOT NULL,
	[countTotal] [int] NOT NULL,
 CONSTRAINT [PK_SportItem] PRIMARY KEY CLUSTERED 
) ON [PRIMARY]

GO


IF OBJECT_ID('dbo.rent') IS NULL
  BEGIN
    PRINT 'Creating STORED PROCEDURE dbo.rent (placeholder)';
    EXECUTE ('CREATE PROCEDURE dbo.rent AS RETURN 0');
  END
GO

PRINT 'Altering STORED PROCEDURE dbo.rent'
GO

ALTER PROCEDURE dbo.rent
(
 @id INT,
 @result INT OUTPUT
)
AS
BEGIN

  UPDATE [dbo].[SportItem]
  SET
    countInStock -= 1
  WHERE
    id = @id
    AND countInStock > 0
	
	SET @result=@@ROWCOUNT
END;


IF OBJECT_ID('dbo.getBack') IS NULL
  BEGIN
    PRINT 'Creating STORED PROCEDURE dbo.getBack (placeholder)';
    EXECUTE ('CREATE PROCEDURE dbo.getBack AS RETURN 0');
  END
GO

PRINT 'Altering STORED PROCEDURE dbo.getBack'
GO

ALTER PROCEDURE dbo.getBack
(
 @id INT,
 @result INT OUTPUT
)
AS
BEGIN

  UPDATE [dbo].[SportItem]
  SET
    countInStock += 1
  WHERE
    id = @id
    AND countInStock <= countTotal
	
	SET @result=@@ROWCOUNT
END;


IF OBJECT_ID('dbo.find') IS NULL
  BEGIN
    PRINT 'Creating STORED PROCEDURE dbo.find (placeholder)';
    EXECUTE ('CREATE PROCEDURE dbo.find AS RETURN 0');
  END
GO

PRINT 'Altering STORED PROCEDURE dbo.find'
GO

ALTER PROCEDURE dbo.find(@id INT)
AS
BEGIN
SELECT [id]
      ,[name]
      ,[price]
      ,[countInStock]
      ,[countTotal]
  FROM [dbo].[SportItem]
WHERE 
id=@id
END;




INSERT INTO [dbo].[SportItem]
           ([id]
           ,[name]
           ,[price]
           ,[countInStock]
           ,[countTotal])
     VALUES
           (1,'Коньки женские',4,10,140),
		   (2,'Коньки детские',2,30,30),
		   (3,'Коньки экстрим',5,6,6),
		   (4,'Шлем тренировочный',1.75,5,50),
		   (5,'Шлем детский',1.45,8,8),
		   (6,'Защита для рук',0.5,14,14),
		   (7,'Защита для ног',0.5,14,14),
		   (8,'Клюшка хоккейная',1.25,39,200),
		   (9,'Клюшка детская',1,100,100),
		   (10,'Перчатки',0.5,10,100);
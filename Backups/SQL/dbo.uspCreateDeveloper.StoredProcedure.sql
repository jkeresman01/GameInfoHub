USE [GameArticles2]
GO
/****** Object:  StoredProcedure [dbo].[uspCreateDeveloper]    Script Date: 7/7/2025 10:59:42 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO


-- DEVELOPER

CREATE PROCEDURE [dbo].[uspCreateDeveloper]
    @Name NVARCHAR(100),
    @DeveloperId INT OUTPUT
AS
BEGIN
    INSERT INTO Developer (Name)
    VALUES (@Name);

    SET @DeveloperId = SCOPE_IDENTITY();
END
GO

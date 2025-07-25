USE [GameArticles2]
GO
/****** Object:  StoredProcedure [dbo].[uspCreateCategory]    Script Date: 7/7/2025 10:59:42 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

--	CATEGORY

CREATE   PROCEDURE [dbo].[uspCreateCategory]
    @Name NVARCHAR(100),
    @CategoryId INT OUTPUT
AS
BEGIN
    INSERT INTO Category (Name)
    VALUES (@Name);

    SET @CategoryId = SCOPE_IDENTITY();
END
GO

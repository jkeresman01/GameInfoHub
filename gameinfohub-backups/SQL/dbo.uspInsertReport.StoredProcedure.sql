USE [GameArticles2]
GO
/****** Object:  StoredProcedure [dbo].[uspInsertReport]    Script Date: 7/7/2025 10:59:42 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

-- REPORT

CREATE   PROCEDURE [dbo].[uspInsertReport]
    @Title NVARCHAR(255),
    @Content NVARCHAR(MAX),
    @UserId INT,
    @ArticleId INT,
    @ReportId INT OUTPUT
AS
BEGIN
    INSERT INTO Report (Title, Content, UserId, ArticleId)
    VALUES (@Title, @Content, @UserId, @ArticleId);

    SET @ReportId = SCOPE_IDENTITY();
END
GO

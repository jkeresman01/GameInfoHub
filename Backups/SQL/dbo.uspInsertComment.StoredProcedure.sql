USE [GameArticles2]
GO
/****** Object:  StoredProcedure [dbo].[uspInsertComment]    Script Date: 7/7/2025 10:59:42 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

-- COMMENT

CREATE   PROCEDURE [dbo].[uspInsertComment]
    @Title NVARCHAR(255),
    @Content NVARCHAR(MAX),
    @UserId INT,
    @GameId INT,
    @CommentId INT OUTPUT
AS
BEGIN
    INSERT INTO Comment (Title, Content, UserId, GameId)
    VALUES (@Title, @Content, @UserId, @GameId);

    SET @CommentId = SCOPE_IDENTITY();
END
GO

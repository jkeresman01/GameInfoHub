USE [GameArticles2]
GO
/****** Object:  StoredProcedure [dbo].[uspRemoveGenresFromGame]    Script Date: 7/7/2025 10:59:42 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE   PROCEDURE [dbo].[uspRemoveGenresFromGame]
    @GameId INT
AS
BEGIN
    DELETE FROM GameGenre WHERE GameId = @GameId;
END
GO

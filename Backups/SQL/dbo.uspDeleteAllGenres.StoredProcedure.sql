USE [GameArticles2]
GO
/****** Object:  StoredProcedure [dbo].[uspDeleteAllGenres]    Script Date: 7/7/2025 10:59:42 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE PROCEDURE [dbo].[uspDeleteAllGenres]
AS
BEGIN
    DELETE FROM Genre;
END
GO

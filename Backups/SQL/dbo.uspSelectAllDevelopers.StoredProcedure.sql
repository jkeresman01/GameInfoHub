USE [GameArticles2]
GO
/****** Object:  StoredProcedure [dbo].[uspSelectAllDevelopers]    Script Date: 7/7/2025 10:59:42 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE PROCEDURE [dbo].[uspSelectAllDevelopers]
AS
BEGIN
    SELECT Id, Name
    FROM Developer;
END
GO

USE [GameArticles2]
GO
/****** Object:  StoredProcedure [dbo].[uspSelectDeveloperWithId]    Script Date: 7/7/2025 10:59:42 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE   PROCEDURE [dbo].[uspSelectDeveloperWithId]
    @Id INT
AS
BEGIN
    SELECT Id, Name
    FROM Developer
    WHERE Id = @Id;
END
GO

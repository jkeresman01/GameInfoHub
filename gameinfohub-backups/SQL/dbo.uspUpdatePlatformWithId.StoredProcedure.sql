USE [GameArticles2]
GO
/****** Object:  StoredProcedure [dbo].[uspUpdatePlatformWithId]    Script Date: 7/7/2025 10:59:42 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE PROCEDURE [dbo].[uspUpdatePlatformWithId]
    @PlatformId INT,
    @Name NVARCHAR(100)
AS
BEGIN
    UPDATE Platform
    SET Name = @Name
    WHERE Id = @PlatformId;
END
GO

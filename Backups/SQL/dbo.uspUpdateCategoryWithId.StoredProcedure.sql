USE [GameArticles2]
GO
/****** Object:  StoredProcedure [dbo].[uspUpdateCategoryWithId]    Script Date: 7/7/2025 10:59:42 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE   PROCEDURE [dbo].[uspUpdateCategoryWithId]
    @CategoryId INT,
    @Name NVARCHAR(100)
AS
BEGIN
    UPDATE Category
    SET Name = @Name
    WHERE Id = @CategoryId;
END
GO

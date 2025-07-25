USE [GameArticles2]
GO
/****** Object:  StoredProcedure [dbo].[uspUpdateUserWithId]    Script Date: 7/7/2025 10:59:42 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE   PROCEDURE [dbo].[uspUpdateUserWithId]
    @UserId INT,
    @Username NVARCHAR(50),
    @FirstName NVARCHAR(50),
    @LastName NVARCHAR(50),
    @PasswordHash NVARCHAR(255),
    @PicturePath NVARCHAR(255),
    @Email NVARCHAR(100)
AS
BEGIN
    DECLARE @RoleId INT = (SELECT Id FROM Role WHERE Name = 'User');

    UPDATE [User]
    SET Username = @Username,
        FirstName = @FirstName,
        LastName = @LastName,
        PasswordHash = @PasswordHash,
        PicturePath = @PicturePath,
        Email = @Email,
        RoleId = @RoleId,
        UpdatedAt = GETDATE()
    WHERE Id = @UserId;
END
GO

USE [GameArticles2]
GO
/****** Object:  Table [dbo].[GamePlatform]    Script Date: 7/7/2025 10:59:42 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[GamePlatform](
	[GameId] [int] NOT NULL,
	[PlatformId] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[GameId] ASC,
	[PlatformId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
ALTER TABLE [dbo].[GamePlatform]  WITH CHECK ADD FOREIGN KEY([GameId])
REFERENCES [dbo].[Game] ([Id])
GO
ALTER TABLE [dbo].[GamePlatform]  WITH CHECK ADD FOREIGN KEY([PlatformId])
REFERENCES [dbo].[Platform] ([Id])
GO

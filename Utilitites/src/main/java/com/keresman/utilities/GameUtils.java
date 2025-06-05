package com.keresman.utilities;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public class GameUtils {

    private static final Set<String> GAME_TITLES = Set.of(
        "Battlefield (2025)",
        "Black Panther",
        "Boltgun 2",
        "Borderlands 2",
        "Borderlands 3",
        "Borderlands 4",
        "Borderlands Online",
        "Bionicle: Masks of Power",
        "Call of Duty",
        "Clair Obscur: Expedition 33",
        "Cyberpunk 2077",
        "Cyberpunk 2077: Phantom Liberty",
        "Dead Island 2",
        "Death Stranding Director's Cut",
        "Diablo 4: Vessel Of Hatred",
        "Diablo IV",
        "Doom: The Dark Ages",
        "DOOM (2016)",
        "DOOM Eternal",
        "Dune: Awakening",
        "Elden Ring",
        "Elden Ring: Nightreign",
        "F1 25",
        "Ghost of Y?tei",
        "Goat Simulator 3",
        "Helldivers 2",
        "Mario Kart World",
        "Marvel 1943: Rise of Hydra",
        "Persona 4",
        "Pokémon Legends: Z-A",
        "Pokémon Scarlet and Violet",
        "Quantum Witch",
        "Raidou Remastered: The Mystery of the Soulless Army",
        "Rayman",
        "Red Dead Redemption 2",
        "Star Wars",
        "Star Wars: Battlefront II",
        "Stellar Blade",
        "Stellar Blade 2",
        "Street Fighter",
        "Street Fighter 6",
        "Supremacy: Warhammer 40,000",
        "The Elder Scrolls IV: Oblivion",
        "The Elder Scrolls IV: Oblivion Remastered",
        "The Elder Scrolls V: Skyrim",
        "The Witcher 3: Wild Hunt",
        "The Witcher 4",
        "Total War: Warhammer III",
        "Warhammer 40,000: Dark Heresy",
        "Warhammer 40,000: Darktide",
        "Warhammer 40,000: Dawn of War - Definitive Edition",
        "Warhammer 40,000: Mechanicus 2",
        "Warhammer 40,000: Space Marine - Master Crafted Edition",
        "Warhammer 40,000: Space Marine 2",
        "World of Warcraft",
        "Yakuza 0"
    );

    public static Optional<String> extractGameName(String data) {
        return isWhitelistedGameTitle(data) ? Optional.of(data) : Optional.empty();
    }

    private static boolean isWhitelistedGameTitle(String entry) {
        return GAME_TITLES.contains(entry);
    }
}

//
//    private static final Set<String> bannedKeywords = Set.of(
//            "PC", "PS5", "PS4", "PS3", "Xbox", "Xbox 360", "Xbox One", "Xbox Series X/S", "Nintendo Switch", "Nintendo Switch 2", "Mac", "iOS", "Android",
//            "Steam", "Game Pass", "PlayStation Plus",
//            "Open World", "RPG", "Shooter", "Strategy", "Platformer", "Fighting", "Simulation", "Story Rich", "Fantasy", "Horror", "Comedy",
//            "First person", "Third person", "Single Player", "Multiplayer Cooperative", "Multiplayer Competitive",
//            "Bird view / Isometric", "Side view", "Card Games", "Sports", "Management", "Sandbox", "Visual Novel", "Dating", "Mods", "&",
//            "Action Adventure", "Quiz/Trivia"
//    );
//
//    private static final Set<String> bannedStudios = Set.of(
//            "Sony", "SEGA", "Capcom", "CD Projekt RED", "Bandai Namco Entertainment", "Ubisoft", "Focus Entertainment", "Activision",
//            "Warner Bros. Games", "Electronic Arts", "FromSoftware", "Obsidian Entertainment", "Coffee Stain Studios",
//            "The LEGO Group", "Square Enix", "Konami", "Virtuos", "Sucker Punch Productions", "505 Games", "Atlus", "Arrowhead Game Studios",
//            "Sandfall Interactive", "Kepler Interactive", "Bethesda Softworks", "Bethesda Game Studios", "2K", "2K Games", "Epic Games",
//            "Nintendo", "Blizzard Entertainment", "Fatshark Games", "Stillfront Group", "Bulwark Studios", "The Creative Assembly", "Skydance Interactive",
//            "Savage Entertainment", "Pandemic Studios", "Ubisoft Entertainment", "Superscape", "4J Studios", "Nacon", "Cyanide Studio",
//            "IO Interactive", "Shift Up Corporation", "Iron Galaxy Studios", "Aspyr", "Gearbox Software", "Bungie", "id Software", "Marvel", "Nvidia"
//    );
//
//    private static final Set<String> knownGameWhitelist = Set.of(
//            "Rayman", "Fortnite", "Helldivers 2", "Cyberpunk 2077", "Elden Ring", "The Witcher 3: Wild Hunt", "The Witcher 4", "Atomic Heart",
//            "Stellar Blade", "Stellar Blade 2", "Borderlands 2", "Borderlands 3", "Borderlands 4", "Avowed", "Marathon", "Doom: The Dark Ages",
//            "DOOM (2016)", "007: First Light", "Monster Hunter Wilds", "Clair Obscur: Expedition 33", "F1 25", "Goat Simulator 3",
//            "Bionicle: Masks of Power", "Red Dead Redemption 2", "Street Fighter 6", "Street Fighter", "Dune: Awakening", "Persona 4",
//            "Pokémon Legends: Z-A", "Diablo 4: Vessel Of Hatred", "Warhammer 40,000: Space Marine 2", "Warhammer 40,000: Darktide",
//            "Warhammer 40,000: Mechanicus 2", "Total War: Warhammer III", "Warhammer 40,000: Dawn of War - Definitive Edition",
//            "Warhammer 40,000: Space Marine - Master Crafted Edition", "Supremacy: Warhammer 40,000", "Boltgun 2"
//    );
//
//    public static Set<String> extractGamesFromCategories(List<String> categories) {
//        Set<String> result = new TreeSet<>();
//        for (String raw : categories) {
//            String cat = raw.trim();
//            if (cat.isEmpty()) {
//                continue;
//            }
//            if (knownGameWhitelist.contains(cat)) {
//                result.add(cat);
//                continue;
//            }
//            if (bannedKeywords.contains(cat) || bannedStudios.contains(cat)) {
//                continue;
//            }
//
//            if (cat.contains(":")
//                    || cat.matches(".*\\d.*")
//                    || cat.matches("^[A-Z][a-z]+(\\s[A-Z0-9][a-z0-9]*)+$")) {
//                result.add(cat);
//            }
//        }
//        return result;
//    }
//}

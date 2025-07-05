package com.keresman.utilities;

import java.util.Optional;
import java.util.Set;

//Remove, for speed whitelists some games
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

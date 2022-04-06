# Treasury
This is an addon for the SimplePets v5 plugin.

### Requirements:
- [Treasury](https://www.spigotmc.org/resources/99531/) Plugin `(At least v1.1.0 [or v1.1.0-937ec97-RELEASE on Spigot])`

### Default configuration (Located in `plugins/SimplePets/Addons/config/Treasury.yml`)
```yaml
# Disabling this will make the items show the price, but if the player has bypass permissions he wont have to pay
# Default: true
Hide-Price-If-Bypassed: true

# Should players have to pay each time they spawn a pet?
# Default: false
Pay-Per-Use-Enabled: false

Price:
  # If a pet is free this will be in the place of the price in the lore
  # Default: 'Free'
  Free: Free
  # If the player has the bypass permission, will be in the place of the price in the lore
  # Default: 'BYPASSED'
  Bypassed: BYPASSED

# Here is where you can set the translations for the 2 boolean values (true/false)
Boolean:
  'true': '&#92fc98true'
  'false': '&#fa7d7dfalse'
  
Messages:
  prefix: '&eSimplePets &6>>'
  PurchaseSuccessful:
    # This message will be sent if the purchase it successful
    # Placeholders:
    # - {prefix} (uses the customized prefix)
    # - {type} (will get what type of pet it is)
    # - {price} (what price the pet is)
    One-Time-Purchase: '{prefix} &7You have Successfully Purchased the {type} Pet.'
    # This message will be sent if the purchase it successful while Pay-Per-Use is set to true
    # Placeholders:
    # - {prefix} (uses the customized prefix)
    # - {type} (will get what type of pet it is)
    # - {price} (what price the pet is)
    Pay-Per-Use: '{prefix} &7You have Successfully Paid for the {type} Pet.'
  # This message will be sent if the player does not have enough money to buy the pet
  # Placeholders:
  # - {prefix} (uses the customized prefix)
  # - {type} (will get what type of pet it is)
  # - {price} (what price the pet is)
  InsufficientFunds: '{prefix} &cYou do not have enough money to buy this pet, you
    need to have {price}'
  Lore-Lines:
    # These Lore Lines will only be used if 'Pay-Per-Use' is set to false
    # Placeholders:
    # - {price} (price of the pet)
    # - {purchased} (true/false if the player purchased the pet)
    One-Time-Purchase:
    - '&#ffbf5ePrice: &#99ffac{price}'
    - '&#ffbf5ePurchased: {purchased}'
    # These lines get added to the pet items when the GUI is opened
    # Placeholders:
    # - {price} (price of the pet)
    # - {purchased} (true/false if the player purchased the pet)
    Pay-Per-Use:
    - '&#ffbf5ePrice: &#99ffac{price}'

bypass_permissions:
  # This is the master permission, Will ignore all individual bypass permissions listed below
  parent: pet.treasury.bypass
  type:
    # This is a bypass permission for the armor_stand pet, who ever has this permission will now have to pay for this pet
    armor_stand: pet.treasury.bypass.armor_stand
    # This is a bypass permission for the axolotl pet, who ever has this permission will now have to pay for this pet
    axolotl: pet.treasury.bypass.axolotl
    # This is a bypass permission for the bat pet, who ever has this permission will now have to pay for this pet
    bat: pet.treasury.bypass.bat
    # This is a bypass permission for the bee pet, who ever has this permission will now have to pay for this pet
    bee: pet.treasury.bypass.bee
    # This is a bypass permission for the blaze pet, who ever has this permission will now have to pay for this pet
    blaze: pet.treasury.bypass.blaze
    # This is a bypass permission for the cat pet, who ever has this permission will now have to pay for this pet
    cat: pet.treasury.bypass.cat
    # This is a bypass permission for the cave_spider pet, who ever has this permission will now have to pay for this pet
    cave_spider: pet.treasury.bypass.cave_spider
    # This is a bypass permission for the chicken pet, who ever has this permission will now have to pay for this pet
    chicken: pet.treasury.bypass.chicken
    # This is a bypass permission for the cod pet, who ever has this permission will now have to pay for this pet
    cod: pet.treasury.bypass.cod
    # This is a bypass permission for the cow pet, who ever has this permission will now have to pay for this pet
    cow: pet.treasury.bypass.cow
    # This is a bypass permission for the creeper pet, who ever has this permission will now have to pay for this pet
    creeper: pet.treasury.bypass.creeper
    # This is a bypass permission for the dolphin pet, who ever has this permission will now have to pay for this pet
    dolphin: pet.treasury.bypass.dolphin
    # This is a bypass permission for the donkey pet, who ever has this permission will now have to pay for this pet
    donkey: pet.treasury.bypass.donkey
    # This is a bypass permission for the drowned pet, who ever has this permission will now have to pay for this pet
    drowned: pet.treasury.bypass.drowned
    # This is a bypass permission for the elder_guardian pet, who ever has this permission will now have to pay for this pet
    elder_guardian: pet.treasury.bypass.elder_guardian
    # This is a bypass permission for the enderman pet, who ever has this permission will now have to pay for this pet
    enderman: pet.treasury.bypass.enderman
    # This is a bypass permission for the endermite pet, who ever has this permission will now have to pay for this pet
    endermite: pet.treasury.bypass.endermite
    # This is a bypass permission for the evoker pet, who ever has this permission will now have to pay for this pet
    evoker: pet.treasury.bypass.evoker
    # This is a bypass permission for the fox pet, who ever has this permission will now have to pay for this pet
    fox: pet.treasury.bypass.fox
    # This is a bypass permission for the ghast pet, who ever has this permission will now have to pay for this pet
    ghast: pet.treasury.bypass.ghast
    # This is a bypass permission for the giant pet, who ever has this permission will now have to pay for this pet
    giant: pet.treasury.bypass.giant
    # This is a bypass permission for the glow_squid pet, who ever has this permission will now have to pay for this pet
    glow_squid: pet.treasury.bypass.glow_squid
    # This is a bypass permission for the goat pet, who ever has this permission will now have to pay for this pet
    goat: pet.treasury.bypass.goat
    # This is a bypass permission for the guardian pet, who ever has this permission will now have to pay for this pet
    guardian: pet.treasury.bypass.guardian
    # This is a bypass permission for the hoglin pet, who ever has this permission will now have to pay for this pet
    hoglin: pet.treasury.bypass.hoglin
    # This is a bypass permission for the horse pet, who ever has this permission will now have to pay for this pet
    horse: pet.treasury.bypass.horse
    # This is a bypass permission for the husk pet, who ever has this permission will now have to pay for this pet
    husk: pet.treasury.bypass.husk
    # This is a bypass permission for the illusioner pet, who ever has this permission will now have to pay for this pet
    illusioner: pet.treasury.bypass.illusioner
    # This is a bypass permission for the iron_golem pet, who ever has this permission will now have to pay for this pet
    iron_golem: pet.treasury.bypass.iron_golem
    # This is a bypass permission for the llama pet, who ever has this permission will now have to pay for this pet
    llama: pet.treasury.bypass.llama
    # This is a bypass permission for the magma_cube pet, who ever has this permission will now have to pay for this pet
    magma_cube: pet.treasury.bypass.magma_cube
    # This is a bypass permission for the mooshroom pet, who ever has this permission will now have to pay for this pet
    mooshroom: pet.treasury.bypass.mooshroom
    # This is a bypass permission for the mule pet, who ever has this permission will now have to pay for this pet
    mule: pet.treasury.bypass.mule
    # This is a bypass permission for the ocelot pet, who ever has this permission will now have to pay for this pet
    ocelot: pet.treasury.bypass.ocelot
    # This is a bypass permission for the panda pet, who ever has this permission will now have to pay for this pet
    panda: pet.treasury.bypass.panda
    # This is a bypass permission for the parrot pet, who ever has this permission will now have to pay for this pet
    parrot: pet.treasury.bypass.parrot
    # This is a bypass permission for the phantom pet, who ever has this permission will now have to pay for this pet
    phantom: pet.treasury.bypass.phantom
    # This is a bypass permission for the pig pet, who ever has this permission will now have to pay for this pet
    pig: pet.treasury.bypass.pig
    # This is a bypass permission for the piglin pet, who ever has this permission will now have to pay for this pet
    piglin: pet.treasury.bypass.piglin
    # This is a bypass permission for the piglin_brute pet, who ever has this permission will now have to pay for this pet
    piglin_brute: pet.treasury.bypass.piglin_brute
    # This is a bypass permission for the pillager pet, who ever has this permission will now have to pay for this pet
    pillager: pet.treasury.bypass.pillager
    # This is a bypass permission for the polarbear pet, who ever has this permission will now have to pay for this pet
    polarbear: pet.treasury.bypass.polarbear
    # This is a bypass permission for the pufferfish pet, who ever has this permission will now have to pay for this pet
    pufferfish: pet.treasury.bypass.pufferfish
    # This is a bypass permission for the rabbit pet, who ever has this permission will now have to pay for this pet
    rabbit: pet.treasury.bypass.rabbit
    # This is a bypass permission for the ravager pet, who ever has this permission will now have to pay for this pet
    ravager: pet.treasury.bypass.ravager
    # This is a bypass permission for the salmon pet, who ever has this permission will now have to pay for this pet
    salmon: pet.treasury.bypass.salmon
    # This is a bypass permission for the sheep pet, who ever has this permission will now have to pay for this pet
    sheep: pet.treasury.bypass.sheep
    # This is a bypass permission for the shulker pet, who ever has this permission will now have to pay for this pet
    shulker: pet.treasury.bypass.shulker
    # This is a bypass permission for the silverfish pet, who ever has this permission will now have to pay for this pet
    silverfish: pet.treasury.bypass.silverfish
    # This is a bypass permission for the skeleton pet, who ever has this permission will now have to pay for this pet
    skeleton: pet.treasury.bypass.skeleton
    # This is a bypass permission for the skeleton_horse pet, who ever has this permission will now have to pay for this pet
    skeleton_horse: pet.treasury.bypass.skeleton_horse
    # This is a bypass permission for the slime pet, who ever has this permission will now have to pay for this pet
    slime: pet.treasury.bypass.slime
    # This is a bypass permission for the snowman pet, who ever has this permission will now have to pay for this pet
    snowman: pet.treasury.bypass.snowman
    # This is a bypass permission for the spider pet, who ever has this permission will now have to pay for this pet
    spider: pet.treasury.bypass.spider
    # This is a bypass permission for the squid pet, who ever has this permission will now have to pay for this pet
    squid: pet.treasury.bypass.squid
    # This is a bypass permission for the stray pet, who ever has this permission will now have to pay for this pet
    stray: pet.treasury.bypass.stray
    # This is a bypass permission for the strider pet, who ever has this permission will now have to pay for this pet
    strider: pet.treasury.bypass.strider
    # This is a bypass permission for the trader_llama pet, who ever has this permission will now have to pay for this pet
    trader_llama: pet.treasury.bypass.trader_llama
    # This is a bypass permission for the tropical_fish pet, who ever has this permission will now have to pay for this pet
    tropical_fish: pet.treasury.bypass.tropical_fish
    # This is a bypass permission for the turtle pet, who ever has this permission will now have to pay for this pet
    turtle: pet.treasury.bypass.turtle
    # This is a bypass permission for the vex pet, who ever has this permission will now have to pay for this pet
    vex: pet.treasury.bypass.vex
    # This is a bypass permission for the villager pet, who ever has this permission will now have to pay for this pet
    villager: pet.treasury.bypass.villager
    # This is a bypass permission for the vindicator pet, who ever has this permission will now have to pay for this pet
    vindicator: pet.treasury.bypass.vindicator
    # This is a bypass permission for the wandering_trader pet, who ever has this permission will now have to pay for this pet
    wandering_trader: pet.treasury.bypass.wandering_trader
    # This is a bypass permission for the witch pet, who ever has this permission will now have to pay for this pet
    witch: pet.treasury.bypass.witch
    # This is a bypass permission for the wither pet, who ever has this permission will now have to pay for this pet
    wither: pet.treasury.bypass.wither
    # This is a bypass permission for the wither_skeleton pet, who ever has this permission will now have to pay for this pet
    wither_skeleton: pet.treasury.bypass.wither_skeleton
    # This is a bypass permission for the wolf pet, who ever has this permission will now have to pay for this pet
    wolf: pet.treasury.bypass.wolf
    # This is a bypass permission for the zoglin pet, who ever has this permission will now have to pay for this pet
    zoglin: pet.treasury.bypass.zoglin
    # This is a bypass permission for the zombie pet, who ever has this permission will now have to pay for this pet
    zombie: pet.treasury.bypass.zombie
    # This is a bypass permission for the zombie_horse pet, who ever has this permission will now have to pay for this pet
    zombie_horse: pet.treasury.bypass.zombie_horse
    # This is a bypass permission for the zombie_villager pet, who ever has this permission will now have to pay for this pet
    zombie_villager: pet.treasury.bypass.zombie_villager
    # This is a bypass permission for the zombified_piglin pet, who ever has this permission will now have to pay for this pet
    zombified_piglin: pet.treasury.bypass.zombified_piglin
type:
  # The price of the armor_stand pet
  armor_stand: 2000
  # The price of the axolotl pet
  axolotl: 2000
  # The price of the bat pet
  bat: 2000
  # The price of the bee pet
  bee: 2000
  # The price of the blaze pet
  blaze: 2000
  # The price of the cat pet
  cat: 2000
  # The price of the cave_spider pet
  cave_spider: 2000
  # The price of the chicken pet
  chicken: 2000
  # The price of the cod pet
  cod: 2000
  # The price of the cow pet
  cow: 2000
  # The price of the creeper pet
  creeper: 2000
  # The price of the dolphin pet
  dolphin: 2000
  # The price of the donkey pet
  donkey: 2000
  # The price of the drowned pet
  drowned: 2000
  # The price of the elder_guardian pet
  elder_guardian: 2000
  # The price of the enderman pet
  enderman: 2000
  # The price of the endermite pet
  endermite: 2000
  # The price of the evoker pet
  evoker: 2000
  # The price of the fox pet
  fox: 2000
  # The price of the ghast pet
  ghast: 2000
  # The price of the giant pet
  giant: 2000
  # The price of the glow_squid pet
  glow_squid: 2000
  # The price of the goat pet
  goat: 2000
  # The price of the guardian pet
  guardian: 2000
  # The price of the hoglin pet
  hoglin: 2000
  # The price of the horse pet
  horse: 2000
  # The price of the husk pet
  husk: 2000
  # The price of the illusioner pet
  illusioner: 2000
  # The price of the iron_golem pet
  iron_golem: 2000
  # The price of the llama pet
  llama: 2000
  # The price of the magma_cube pet
  magma_cube: 2000
  # The price of the mooshroom pet
  mooshroom: 2000
  # The price of the mule pet
  mule: 2000
  # The price of the ocelot pet
  ocelot: 2000
  # The price of the panda pet
  panda: 2000
  # The price of the parrot pet
  parrot: 2000
  # The price of the phantom pet
  phantom: 2000
  # The price of the pig pet
  pig: 2000
  # The price of the piglin pet
  piglin: 2000
  # The price of the piglin_brute pet
  piglin_brute: 2000
  # The price of the pillager pet
  pillager: 2000
  # The price of the polarbear pet
  polarbear: 2000
  # The price of the pufferfish pet
  pufferfish: 2000
  # The price of the rabbit pet
  rabbit: 2000
  # The price of the ravager pet
  ravager: 2000
  # The price of the salmon pet
  salmon: 2000
  # The price of the sheep pet
  sheep: 2000
  # The price of the shulker pet
  shulker: 2000
  # The price of the silverfish pet
  silverfish: 2000
  # The price of the skeleton pet
  skeleton: 2000
  # The price of the skeleton_horse pet
  skeleton_horse: 2000
  # The price of the slime pet
  slime: 2000
  # The price of the snowman pet
  snowman: 2000
  # The price of the spider pet
  spider: 2000
  # The price of the squid pet
  squid: 2000
  # The price of the stray pet
  stray: 2000
  # The price of the strider pet
  strider: 2000
  # The price of the trader_llama pet
  trader_llama: 2000
  # The price of the tropical_fish pet
  tropical_fish: 2000
  # The price of the turtle pet
  turtle: 2000
  # The price of the vex pet
  vex: 2000
  # The price of the villager pet
  villager: 2000
  # The price of the vindicator pet
  vindicator: 2000
  # The price of the wandering_trader pet
  wandering_trader: 2000
  # The price of the witch pet
  witch: 2000
  # The price of the wither pet
  wither: 2000
  # The price of the wither_skeleton pet
  wither_skeleton: 2000
  # The price of the wolf pet
  wolf: 2000
  # The price of the zoglin pet
  zoglin: 2000
  # The price of the zombie pet
  zombie: 2000
  # The price of the zombie_horse pet
  zombie_horse: 2000
  # The price of the zombie_villager pet
  zombie_villager: 2000
  # The price of the zombified_piglin pet
  zombified_piglin: 2000
```

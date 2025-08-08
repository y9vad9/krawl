package com.y9vad9.krawl.event

/**
 * Represents a Brawl Stars event mode.
 *
 * This class encapsulates the raw string identifier for a specific event mode in Brawl Stars.
 * Event modes define the rules and objectives of various game modes within the game.
 *
 * @property rawString The raw string identifier for the event mode.
 */
@JvmInline
public value class EventMode(public val rawString: String) : Comparable<EventMode> {
    public companion object {
        /**
         * Represents "Gem Grab" event mode in Brawl Stars.
         *
         * ## Event description
         * Collect Gems that pop out of the Gem Mine in the middle of the map. Or, just
         * take them from fallen opponents! Hold ten Gems for the duration of a
         * countdown to win the game!
         *
         * **[Learn more about this event on Brawlify](https://brawlify.com/gamemodes/detail/Gem-Grab)**
         *
         */
        public val GEM_GRAB: EventMode = EventMode("gemGrab")

        /**
         * Represents "Heist" event mode in Brawl Stars.
         *
         * ## Event description
         * Protect your team's valuable safe, while trying to break open the enemy
         * team's safe at the same time! Whichever team busts open the enemy safe first
         * wins.  If time runs out, the team that caused more damage to the enemy team's
         * safe is declared winner.
         *
         * **[Learn more about this event on Brawlify](https://brawlify.com/gamemodes/detail/Heist)**
         *
         */
        public val HEIST: EventMode = EventMode("heist")

        /**
         * Represents "Bounty" event mode in Brawl Stars.
         *
         * ## Event description
         * Collect Stars for your team by defeating players on the enemy team. Every
         * time you defeat an enemy, the bounty on your head increases by one Star, up
         * to seven Stars. Don't give them to the enemy!  The team that collects 20
         * stars first or has more Stars when the clock runs out wins. In the case of a
         * tie, the team holding the blue star wins.
         *
         * **[Learn more about this event on Brawlify](https://brawlify.com/gamemodes/detail/Bounty)**
         *
         */
        public val BOUNTY: EventMode = EventMode("bounty")

        /**
         * Represents "Brawl Ball" event mode in Brawl Stars.
         *
         * ## Event description
         * Take the ball to the opposing team's goal to score! Match ends when one team
         * scores two goals, or at full time.
         *
         * **[Learn more about this event on Brawlify](https://brawlify.com/gamemodes/detail/Brawl-Ball)**
         *
         */
        public val BRAWL_BALL: EventMode = EventMode("brawlBall")

        /**
         * Represents "Solo Showdown" event mode in Brawl Stars.
         *
         * ## Event description
         * Take down the other nine and be the last one standing. Use any means
         * necessary, as you only have one life.
         *
         * **[Learn more about this event on Brawlify](https://brawlify.com/gamemodes/detail/Solo-Showdown)**
         *
         */
        public val SOLO_SHOWDOWN: EventMode = EventMode("soloShowdown")

        /**
         * Represents "Big Game" event mode in Brawl Stars.
         *
         * ## Event description
         * Five players attempt to defeat the BIG BRAWLER.  As the BIG BRAWLER, you'll
         * have a massive power advantage, and a huge amount of health. Defy the hunters
         * and stay in the game as long as you can!  As one of the five hunters, you'll
         * need to work together with your team to take down the BIG BRAWLER before time
         * runs out!
         *
         * **[Learn more about this event on Brawlify](https://brawlify.com/gamemodes/detail/Big-Game)**
         *
         */
        public val BIG_GAME: EventMode = EventMode("bigGame")

        /**
         * Represents "Robo Rumble" event mode in Brawl Stars.
         *
         * ## Event description
         * Defend the safe from greedy Robo Bandits!  Robots will be coming for the safe
         * from all sides, and in ever-increasing numbers. Do your best to defend until
         * the timer runs out!  Robo Rumble difficulty increases in stages, starting
         * from NORMAL and going all the way to INSANE, every time you manage to
         * successfully defend the safe.
         *
         * **[Learn more about this event on Brawlify](https://brawlify.com/gamemodes/detail/Robo-Rumble)**
         *
         */
        public val ROBO_RUMBLE: EventMode = EventMode("roboRumble")

        /**
         * Represents "Duo Showdown" event mode in Brawl Stars.
         *
         * ## Event description
         * Take down the other four teams. If you are defeated, you will respawn in a
         * while if your teammate is still alive!
         *
         * **[Learn more about this event on Brawlify](https://brawlify.com/gamemodes/detail/Duo-Showdown)**
         *
         */
        public val DUO_SHOWDOWN: EventMode = EventMode("duoShowdown")

        /**
         * Represents "Boss Fight" event mode in Brawl Stars.
         *
         * ## Event description
         * Can you beat the formidable Boss Robot? Join forces with two teammates and
         * take down this monster. You can get back in the fight as long as at least one
         * of your teammates is standing. If everyone falls, it's game over!  Boss
         * Fights increase in Challenge, from Normal all the way to Insane, every time
         * you manage to beat the Boss.
         *
         * **[Learn more about this event on Brawlify](https://brawlify.com/gamemodes/detail/Boss-Fight)**
         *
         */
        public val BOSS_FIGHT: EventMode = EventMode("bossFight")

        /**
         * Represents "Spirit Wars" event mode in Brawl Stars.
         *
         * ## Event description
         * Destroy the enemy defense turret! Angel and Demon Spirits are pouring forth
         * from portals to bring their eternal war to you! Collect Amulets to summon
         * Spirits to a Battle. Amulets appear randomly around the middle of the map.
         * Grab an Amulet and hold it for a few seconds to activate it.  There are up to
         * three Battles during each match, when up to 10 Spirits are summoned, equal to
         * the number of Amulets you have. Spirits increase in strength with each
         * battle. Watch out - don't get too close to the enemy turret without Spirits
         * to help you!
         *
         * **[Learn more about this event on Brawlify](https://brawlify.com/gamemodes/detail/Spirit-Wars)**
         *
         */
        public val SPIRIT_WARS: EventMode = EventMode("spiritWars")

        /**
         * Represents "Takedown" event mode in Brawl Stars.
         *
         * ## Event description
         * Deal more damage to the Boss than the other players. The more damage you
         * deal, the higher you will rank in the match.  Collect Power Cubes to increase
         * your Health and Attack damage. Power Cubes will randomly spawn on the map
         * during the battle!
         *
         * **[Learn more about this event on Brawlify](https://brawlify.com/gamemodes/detail/Takedown)**
         *
         */
        public val TAKEDOWN: EventMode = EventMode("takedown")

        /**
         * Represents "Lone Star" event mode in Brawl Stars.
         *
         * ## Event description
         * Collect Stars by defeating enemy players. Every time you defeat an enemy, the
         * bounty on your head increases by one Star, up to seven Stars.  The one with
         * the most Stars when the clock runs out wins.
         *
         * **[Learn more about this event on Brawlify](https://brawlify.com/gamemodes/detail/Lone-Star)**
         *
         */
        public val LONE_STAR: EventMode = EventMode("loneStar")

        /**
         * Represents "Trophy Thieves" event mode in Brawl Stars.
         *
         * ## Event description
         * Grab Trophies from the opposing team and bring them to your base! Your own
         * Trophy must not be missing. Match ends when one team has captured two
         * Trophies, or when time runs out.
         *
         * **[Learn more about this event on Brawlify](https://brawlify.com/gamemodes/detail/Trophy-Thieves)**
         *
         */
        public val TROPHY_THIEVES: EventMode = EventMode("trophyThieves")

        /**
         * Represents "Hot Zone" event mode in Brawl Stars.
         *
         * ## Event description
         * Capture all the Hot Zones to win!  Capture each point by staying in the Hot
         * Zone. The first team to completely capture all points on the map wins! Both
         * teams can capture Hot Zones at the same time, so make sure to keep the enemy
         * team at bay. If time runs out, the team with the highest completion rate of
         * captured zones wins.
         *
         * **[Learn more about this event on Brawlify](https://brawlify.com/gamemodes/detail/Hot-Zone)**
         *
         */
        public val HOT_ZONE: EventMode = EventMode("hotZone")

        /**
         * Represents "Super City Rampage" event mode in Brawl Stars.
         *
         * ## Event description
         * Can you beat the Mega Monster and save the City? Join forces with two
         * teammates to take down the Mega Monster. You can get back in the fight as
         * long as at least one of your teammates is standing. If everyone falls OR all
         * buildings get destroyed, the match is over!  Rampages increase in Challenge,
         * from Normal all the way to Insane, every time you manage to beat the Mega
         * Monster.
         *
         * **[Learn more about this event on Brawlify](https://brawlify.com/gamemodes/detail/Super-City-Rampage)**
         *
         */
        public val SUPER_CITY_RAMPAGE: EventMode = EventMode("superCityRampage")

        /**
         * Represents "Knockout" event mode in Brawl Stars.
         *
         * ## Event description
         * Defeat the opposing team in a best of three Knockout round contest! Be
         * careful: defeated Brawlers stay out for the rest of each round. After a
         * while, poison clouds will seep in from the edges, so make sure to act
         * quickly!  The first team to win two rounds wins the match.
         *
         * **[Learn more about this event on Brawlify](https://brawlify.com/gamemodes/detail/Knockout)**
         *
         */
        public val KNOCKOUT: EventMode = EventMode("knockout")

        /**
         * Represents "Carry The Gift" event mode in Brawl Stars.
         *
         * ## Event description
         * Hold the present to collect points! First team to reach 100% wins the match.
         *
         * **[Learn more about this event on Brawlify](https://brawlify.com/gamemodes/detail/Carry-The-Gift)**
         *
         */
        public val CARRY_THE_GIFT: EventMode = EventMode("carryTheGift")

        /**
         * Represents "Basket Brawl" event mode in Brawl Stars.
         *
         * ## Event description
         * Throw the ball into the opposing team's basket. You score two points from up
         * close, and three points from behind the line. The match ends when one team
         * has 5 points, or the time runs out.
         *
         * **[Learn more about this event on Brawlify](https://brawlify.com/gamemodes/detail/Basket-Brawl)**
         *
         */
        public val BASKET_BRAWL: EventMode = EventMode("basketBrawl")

        /**
         * Represents "Volley Brawl" event mode in Brawl Stars.
         *
         * ## Event description
         * Score points by making the ball land on the opponent's side of the field.
         * First team to 2 points wins! The longer the ball stays in play, the faster it
         * will fly!
         *
         * **[Learn more about this event on Brawlify](https://brawlify.com/gamemodes/detail/Volley-Brawl)**
         *
         */
        public val VOLLEY_BRAWL: EventMode = EventMode("volleyBrawl")

        /**
         * Represents "Duels" event mode in Brawl Stars.
         *
         * ## Event description
         * Assemble a team of 3 Brawlers to battle against an opposing team in an
         * elimination format Duel. Each round is a 1 vs 1 battle, and ends when a
         * Brawler is defeated. Win 3 rounds to win the match!  Picking an effective
         * squad of Brawlers in the right order can greatly enhance your chances of
         * winning.
         *
         * **[Learn more about this event on Brawlify](https://brawlify.com/gamemodes/detail/Duels)**
         *
         */
        public val DUELS: EventMode = EventMode("duels")

        /**
         * Represents "Wipeout" event mode in Brawl Stars.
         *
         * ## Event description
         * Collect points by defeating opponents. The first team to reach <MAX_SCORE>
         * points wins the match!
         *
         * **[Learn more about this event on Brawlify](https://brawlify.com/gamemodes/detail/Wipeout)**
         *
         */
        public val WIPEOUT: EventMode = EventMode("wipeout")

        /**
         * Represents "Payload" event mode in Brawl Stars.
         *
         * ## Event description
         * Push your team's minecart by standing near it. The first team to push their
         * minecart to the goal wins the match! Standing near the opponent's minecart
         * slows it down. If the time runs out, the team that got the furthest wins!
         *
         * **[Learn more about this event on Brawlify](https://brawlify.com/gamemodes/detail/Payload)**
         *
         */
        public val PAYLOAD: EventMode = EventMode("payload")

        /**
         * Represents "Bot Drop" event mode in Brawl Stars.
         *
         * ## Event description
         * Defend against the robot invasion. Destroy robots and collect bolts. First
         * team to collect <MAX_SCORE> bolts wins the match!
         *
         * **[Learn more about this event on Brawlify](https://brawlify.com/gamemodes/detail/Bot-Drop)**
         *
         */
        public val BOT_DROP: EventMode = EventMode("botDrop")

        /**
         * Represents "Hunters" event mode in Brawl Stars.
         *
         * ## Event description
         * It's hunting season!  Collect points by hunting down and defeating enemies.
         * The FIRST player to reach <MAX_SCORE> points wins the match!
         *
         * **[Learn more about this event on Brawlify](https://brawlify.com/gamemodes/detail/Hunters)**
         *
         */
        public val HUNTERS: EventMode = EventMode("hunters")

        /**
         * Represents "Last Stand" event mode in Brawl Stars.
         *
         * ## Event description
         * Corrupted robots have turned against us! 8-Bit is our last and only hope. He
         * carries the secret code and it's crucial he survives! Protect 8-Bit against
         * waves of evil robots until the time runs out to win the match.  Collect the
         * Brawl Coins to keep 8-Bit in the battle!
         *
         * **[Learn more about this event on Brawlify](https://brawlify.com/gamemodes/detail/Last-Stand)**
         *
         */
        public val LAST_STAND: EventMode = EventMode("lastStand")

        /**
         * Represents "Wipeout 5v5" event mode in Brawl Stars.
         *
         * ## Event description
         * Collect points by defeating opponents. The first team to reach <MAX_SCORE>
         * points wins the match!
         *
         * **[Learn more about this event on Brawlify](https://brawlify.com/gamemodes/detail/Wipeout-5v5)**
         *
         */
        public val WIPEOUT_5V5: EventMode = EventMode("wipeout5v5")

        /**
         * Represents "Brawl Ball 5v5" event mode in Brawl Stars.
         *
         * ## Event description
         * Take the ball to the opposing team's goal to score! Match ends when one team
         * scores two goals, or at full time.
         *
         * **[Learn more about this event on Brawlify](https://brawlify.com/gamemodes/detail/Brawl-Ball-5v5)**
         *
         */
        public val BRAWL_BALL_5V5: EventMode = EventMode("brawlBall5v5")

        /**
         * Represents "Gem Grab 5v5" event mode in Brawl Stars.
         *
         * ## Event description
         * Collect Gems that pop out of the Gem Mine in the middle of the map. Or, just
         * take them from fallen opponents! Hold ten gems for the duration of a
         * countdown to win the game!
         *
         * **[Learn more about this event on Brawlify](https://brawlify.com/gamemodes/detail/Gem-Grab-5v5)**
         *
         */
        public val GEM_GRAB_5V5: EventMode = EventMode("gemGrab5v5")

        /**
         * Represents "Trophy Escape" event mode in Brawl Stars.
         *
         * ## Event description
         * Fight enemies and other players for Trophies, escape through an exit zone and
         * gain your prizes!  Exits open when only half of players are left, or when the
         * end countdown starts. Collect Power Cubes to increase your Health and Attack
         * damage.
         *
         * **[Learn more about this event on Brawlify](https://brawlify.com/gamemodes/detail/Trophy-Escape)**
         *
         */
        public val TROPHY_ESCAPE: EventMode = EventMode("trophyEscape")

        /**
         * Represents "Knockout 5v5" event mode in Brawl Stars.
         *
         * ## Event description
         * Defeat the opposing team in a best of three Knockout round contest! Defeated
         * Brawlers stay out for the rest of each round, but their remaining team
         * members level up and get more powerful! After a while, poison clouds will
         * seep in from the edges, so make sure to act quickly!  The first team to win
         * two rounds wins the match.
         *
         * **[Learn more about this event on Brawlify](https://brawlify.com/gamemodes/detail/Knockout-5v5)**
         *
         */
        public val KNOCKOUT_5V5: EventMode = EventMode("knockout5v5")

        /**
         * Represents "Godzilla City Smash" event mode in Brawl Stars.
         *
         * ## Event description
         * Smash the city! Destroy enemy buildings while defending yours.  Pick up
         * transform tokens and turn into Godzilla or Mechagodzilla!
         *
         * **[Learn more about this event on Brawlify](https://brawlify.com/gamemodes/detail/Godzilla-City-Smash)**
         *
         */
        public val GODZILLA_CITY_SMASH: EventMode = EventMode("godzillaCitySmash")

        /**
         * Represents "Paint Brawl" event mode in Brawl Stars.
         *
         * ## Event description
         * Paint the map with your team's color!  Use the <cFFBB00>paint ball</c> to
         * paint the map's floor, or defeat enemy players to create big splashes of
         * color. First team to paint <c88FF88><MAX_SCORE>%</c> of the map wins. If time
         * runs out, the team that has more of the map painted wins!
         *
         * **[Learn more about this event on Brawlify](https://brawlify.com/gamemodes/detail/Paint-Brawl)**
         *
         */
        public val PAINT_BRAWL: EventMode = EventMode("paintBrawl")

        /**
         * Represents "Trio Showdown" event mode in Brawl Stars.
         *
         * ## Event description
         * Take down the other three teams. If you are defeated, you will respawn in a
         * while as long as one of your teammates is still alive!
         *
         * **[Learn more about this event on Brawlify](https://brawlify.com/gamemodes/detail/Trio-Showdown)**
         *
         */
        public val TRIO_SHOWDOWN: EventMode = EventMode("trioShowdown")

        /**
         * Represents "Drum Roll" event mode in Brawl Stars.
         *
         * ## Event description
         * Defeat an enemy to switch your Brawler to the next one in the queue. Whoever
         * takes down an enemy with the final Brawler wins the match!
         *
         * **[Learn more about this event on Brawlify](https://brawlify.com/gamemodes/detail/Drum-Roll)**
         *
         */
        public val DRUM_ROLL: EventMode = EventMode("drumRoll")

        /**
         * Represents "Soul Collector" event mode in Brawl Stars.
         *
         * ## Event description
         * Collect Souls of defeated opponents. The first team to reach <MAX_SCORE>
         * Souls wins the match!
         *
         * **[Learn more about this event on Brawlify](https://brawlify.com/gamemodes/detail/Soul-Collector)**
         *
         */
        public val SOUL_COLLECTOR: EventMode = EventMode("soulCollector")

        /**
         * Represents "Cleaning Duty" event mode in Brawl Stars.
         *
         * ## Event description
         * Starr Park is littered with Trash! Keep the park tidy by picking up as much
         * Trash as possible. The team that picks up the most <c66ff66>Trash</c> wins!
         *
         * **[Learn more about this event on Brawlify](https://brawlify.com/gamemodes/detail/Cleaning-Duty)**
         *
         */
        public val CLEANING_DUTY: EventMode = EventMode("cleaningDuty")

        /**
         * Represents "Solo Showdown Limbo" event mode in Brawl Stars.
         *
         * ## Event description
         * Take down the other nine and be the last one standing. Use any means
         * necessary, as you only have one life.
         *
         * **[Learn more about this event on Brawlify](https://brawlify.com/gamemodes/detail/Solo-Showdown-Limbo)**
         *
         */
        public val SOLO_SHOWDOWN_LIMBO: EventMode = EventMode("soloShowdownLimbo")

        /**
         * Represents "Knockout Limbo" event mode in Brawl Stars.
         *
         * ## Event description
         * Defeat the opposing team in a best of three Knockout round contest! Be
         * careful: defeated Brawlers stay out for the rest of each round. After a
         * while, poison clouds will seep in from the edges, so make sure to act
         * quickly!  The first team to win two rounds wins the match.
         *
         * **[Learn more about this event on Brawlify](https://brawlify.com/gamemodes/detail/Knockout-Limbo)**
         *
         */
        public val KNOCKOUT_LIMBO: EventMode = EventMode("knockoutLimbo")

        /**
         * Represents "Brawl Hockey" event mode in Brawl Stars.
         *
         * ## Event description
         * Take the puck to the opposing team's goal to score! Match ends when one team
         * scores three goals, or at full time.
         *
         * **[Learn more about this event on Brawlify](https://brawlify.com/gamemodes/detail/Brawl-Hockey)**
         *
         */
        public val BRAWL_HOCKEY: EventMode = EventMode("brawlHockey")

        /**
         * Represents "Gem Grab 2v2" event mode in Brawl Stars.
         *
         * ## Event description
         * Collect Gems that pop out of the Gem Mine in the middle of the map. Or just
         * take them from fallen opponents! Hold ten Gems for the countdown duration to
         * win the game!
         *
         * **[Learn more about this event on Brawlify](https://brawlify.com/gamemodes/detail/Gem-Grab-2v2)**
         *
         */
        public val GEM_GRAB_2V2: EventMode = EventMode("gemGrab2v2")

        /**
         * Represents "Special Delivery" event mode in Brawl Stars.
         *
         * ## Event description
         * There is a pizza cart on the track. Push the cart to the enemy side by
         * staying near it!
         *
         * **[Learn more about this event on Brawlify](https://brawlify.com/gamemodes/detail/Special-Delivery)**
         *
         */
        public val SPECIAL_DELIVERY: EventMode = EventMode("specialDelivery")

        /**
         * Represents "Brawl Arena" event mode in Brawl Stars.
         *
         * ## Event description
         * Destroy the enemy base to win in this intense 3v3 battle! As the match
         * progresses, you'll grow stronger as you earn Arena XP. Be on the lookout for
         * the Kaiju, a massive beast that can change the outcome of the game if
         * defeated, and robots that can be defeated for Arena XP. The first team to
         * destroy the opposing base wins, so strategize carefully and work together to
         * claim victory!
         *
         * **[Learn more about this event on Brawlify](https://brawlify.com/gamemodes/detail/Brawl-Arena)**
         *
         */
        public val BRAWL_ARENA: EventMode = EventMode("brawlArena")

        /**
         * Represents "Brawl Ball 2v2" event mode in Brawl Stars.
         *
         * ## Event description
         * Put the ball in the opposing team's goal to score! The match ends when one
         * team scores two goals, or at the end of full time.
         *
         * **[Learn more about this event on Brawlify](https://brawlify.com/gamemodes/detail/Brawl-Ball-2v2)**
         *
         */
        public val BRAWL_BALL_2V2: EventMode = EventMode("brawlBall2v2")

        /**
         * Represents "Knockout 2v2" event mode in Brawl Stars.
         *
         * ## Event description
         * Defeat the opposing team in a best of three Knockout round contest! Be
         * careful: defeated Brawlers stay out for the rest of each round. After a
         * while, poison clouds will seep in from the edges, so make sure to act
         * quickly!  The first team to win two rounds wins the match.
         *
         * **[Learn more about this event on Brawlify](https://brawlify.com/gamemodes/detail/Knockout-2v2)**
         *
         */
        public val KNOCKOUT_2V2: EventMode = EventMode("knockout2v2")

        /**
         * Represents "Hot Zone 2v2" event mode in Brawl Stars.
         *
         * ## Event description
         * Capture all the Hot Zones to win!  Capture each point by staying in the Hot
         * Zone. The first team to completely capture all points on the map wins! Both
         * teams can capture Hot Zones at the same time, so make sure to keep the enemy
         * team at bay. If time runs out, the team with the highest completion rate of
         * captured zones wins.
         *
         * **[Learn more about this event on Brawlify](https://brawlify.com/gamemodes/detail/Hot-Zone-2v2)**
         *
         */
        public val HOT_ZONE_2V2: EventMode = EventMode("hotZone2v2")

        /**
         * Represents "Basket Brawl 2v2" event mode in Brawl Stars.
         *
         * ## Event description
         * Throw the ball into the opposing team's basket. You score two points from up
         * close, and three points from behind the line. The match ends when one team
         * has 5 points or time runs out.
         *
         * **[Learn more about this event on Brawlify](https://brawlify.com/gamemodes/detail/Basket-Brawl-2v2)**
         *
         */
        public val BASKET_BRAWL_2V2: EventMode = EventMode("basketBrawl2v2")

        /**
         * Represents "Brawl Hockey 2v2" event mode in Brawl Stars.
         *
         * ## Event description
         * Take the puck to the opposing team's goal to score! Match ends when one team
         * scores three goals, or at full time.
         *
         * **[Learn more about this event on Brawlify](https://brawlify.com/gamemodes/detail/Brawl-Hockey-2v2)**
         *
         */
        public val BRAWL_HOCKEY_2V2: EventMode = EventMode("brawlHockey2v2")

        /**
         * Represents "Special Delivery 2v2" event mode in Brawl Stars.
         *
         * ## Event description
         * There is a pizza cart on the track. Push the cart to the enemy side by
         * staying near it!
         *
         * **[Learn more about this event on Brawlify](https://brawlify.com/gamemodes/detail/Special-Delivery-2v2)**
         *
         */
        public val SPECIAL_DELIVERY_2V2: EventMode = EventMode("specialDelivery2v2")

        /**
         * Represents "Token Run" event mode in Brawl Stars.
         *
         * ## Event description
         * Play your tokens by taking them to the discard slot. The first team with no
         * tokens remaining wins!  Action tokens trigger special effects: <cAAFFAA>Power
         * Boost - Team members gain 2 power cubes</c> <cFFFF00>Silence - Enemy can't
         * shoot for 3 seconds</c> <cFFAAAA>Rebound - Moves enemy tokens back to
         * base</c>  Pro Tip: You can body block flying enemy tokens!
         *
         * **[Learn more about this event on Brawlify](https://brawlify.com/gamemodes/detail/Token-Run)**
         *
         */
        public val TOKEN_RUN: EventMode = EventMode("tokenRun")

        /**
         * Represents "Treasure Hunt" event mode in Brawl Stars.
         *
         * ## Event description
         * Walk on top of a Treasure Plate to uncover some Treasure. Collect 10
         * Treasures to win!  You cannot steal Treasure that the opponent has already
         * collected.  Treasure Plates in the middle of the map provide Treasure faster!
         *
         * **[Learn more about this event on Brawlify](https://brawlify.com/gamemodes/detail/Treasure-Hunt)**
         *
         */
        public val TREASURE_HUNT: EventMode = EventMode("treasureHunt")

        /**
         * Represents "Vip Hunt" event mode in Brawl Stars.
         *
         * ## Event description
         * Protect your teams VIP, defeat enemy VIP's.
         *
         * **[Learn more about this event on Brawlify](https://brawlify.com/gamemodes/detail/Vip-Hunt)**
         *
         */
        public val VIP_HUNT: EventMode = EventMode("vipHunt")

        /**
         * Represents "Samurai Smash" event mode in Brawl Stars.
         *
         * ## Event description
         * Collect points by picking up <cFFDD00>Daruma dolls</c> dropped by defeated
         * samuraibots and Brawlers.  The first team to reach <cFFDD00><MAX_SCORE>
         * points</c> wins the match.
         *
         * **[Learn more about this event on Brawlify](https://brawlify.com/gamemodes/detail/Samurai-Smash)**
         *
         */
        public val SAMURAI_SMASH: EventMode = EventMode("samuraiSmash")

        /**
         * Represents "Oni Hunt" event mode in Brawl Stars.
         *
         * ## Event description
         * Every time you defeat Oni Kenji, he will return stronger!
         *
         * **[Learn more about this event on Brawlify](https://brawlify.com/gamemodes/detail/Oni-Hunt)**
         *
         */
        public val ONI_HUNT: EventMode = EventMode("oniHunt")

        /**
         * Represents "Dodgebrawl" event mode in Brawl Stars.
         *
         * ## Event description
         * Score by hitting an enemy with a ball. The first team to reach <MAX_SCORE>
         * points wins the match!  No regular takedowns, running out of health stuns
         * Brawlers instead!
         *
         * **[Learn more about this event on Brawlify](https://brawlify.com/gamemodes/detail/Dodgebrawl)**
         *
         */
        public val DODGEBRAWL: EventMode = EventMode("dodgebrawl")
    }

    /**
     * Compares this event mode to another event mode based on their raw string identifiers.
     *
     * @param other The other event mode to compare to.
     * @return A negative integer, zero, or a positive integer as this event mode is less than,
     *         equal to, or greater than the specified event mode.
     */
    override fun compareTo(other: EventMode): Int = rawString.compareTo(other.rawString)
}

/**
 * Checks whether it is a "Gem Grab" event mode.
 * @see EventMode.Companion.GEM_GRAB
 */
public val EventMode.isGemGrab: Boolean get() = this == EventMode.GEM_GRAB

/**
 * Checks whether it is a "Heist" event mode.
 * @see EventMode.Companion.HEIST
 */
public val EventMode.isHeist: Boolean get() = this == EventMode.HEIST

/**
 * Checks whether it is a "Bounty" event mode.
 * @see EventMode.Companion.BOUNTY
 */
public val EventMode.isBounty: Boolean get() = this == EventMode.BOUNTY

/**
 * Checks whether it is a "Brawl Ball" event mode.
 * @see EventMode.Companion.BRAWL_BALL
 */
public val EventMode.isBrawlBall: Boolean get() = this == EventMode.BRAWL_BALL

/**
 * Checks whether it is a "Solo Showdown" event mode.
 * @see EventMode.Companion.SOLO_SHOWDOWN
 */
public val EventMode.isSoloShowdown: Boolean get() = this == EventMode.SOLO_SHOWDOWN

/**
 * Checks whether it is a "Big Game" event mode.
 * @see EventMode.Companion.BIG_GAME
 */
public val EventMode.isBigGame: Boolean get() = this == EventMode.BIG_GAME

/**
 * Checks whether it is a "Robo Rumble" event mode.
 * @see EventMode.Companion.ROBO_RUMBLE
 */
public val EventMode.isRoboRumble: Boolean get() = this == EventMode.ROBO_RUMBLE

/**
 * Checks whether it is a "Duo Showdown" event mode.
 * @see EventMode.Companion.DUO_SHOWDOWN
 */
public val EventMode.isDuoShowdown: Boolean get() = this == EventMode.DUO_SHOWDOWN

/**
 * Checks whether it is a "Boss Fight" event mode.
 * @see EventMode.Companion.BOSS_FIGHT
 */
public val EventMode.isBossFight: Boolean get() = this == EventMode.BOSS_FIGHT

/**
 * Checks whether it is a "Spirit Wars" event mode.
 * @see EventMode.Companion.SPIRIT_WARS
 */
public val EventMode.isSpiritWars: Boolean get() = this == EventMode.SPIRIT_WARS

/**
 * Checks whether it is a "Takedown" event mode.
 * @see EventMode.Companion.TAKEDOWN
 */
public val EventMode.isTakedown: Boolean get() = this == EventMode.TAKEDOWN

/**
 * Checks whether it is a "Lone Star" event mode.
 * @see EventMode.Companion.LONE_STAR
 */
public val EventMode.isLoneStar: Boolean get() = this == EventMode.LONE_STAR

/**
 * Checks whether it is a "Trophy Thieves" event mode.
 * @see EventMode.Companion.TROPHY_THIEVES
 */
public val EventMode.isTrophyThieves: Boolean get() = this == EventMode.TROPHY_THIEVES

/**
 * Checks whether it is a "Hot Zone" event mode.
 * @see EventMode.Companion.HOT_ZONE
 */
public val EventMode.isHotZone: Boolean get() = this == EventMode.HOT_ZONE

/**
 * Checks whether it is a "Super City Rampage" event mode.
 * @see EventMode.Companion.SUPER_CITY_RAMPAGE
 */
public val EventMode.isSuperCityRampage: Boolean get() = this == EventMode.SUPER_CITY_RAMPAGE

/**
 * Checks whether it is a "Knockout" event mode.
 * @see EventMode.Companion.KNOCKOUT
 */
public val EventMode.isKnockout: Boolean get() = this == EventMode.KNOCKOUT

/**
 * Checks whether it is a "Carry The Gift" event mode.
 * @see EventMode.Companion.CARRY_THE_GIFT
 */
public val EventMode.isCarryTheGift: Boolean get() = this == EventMode.CARRY_THE_GIFT

/**
 * Checks whether it is a "Basket Brawl" event mode.
 * @see EventMode.Companion.BASKET_BRAWL
 */
public val EventMode.isBasketBrawl: Boolean get() = this == EventMode.BASKET_BRAWL

/**
 * Checks whether it is a "Volley Brawl" event mode.
 * @see EventMode.Companion.VOLLEY_BRAWL
 */
public val EventMode.isVolleyBrawl: Boolean get() = this == EventMode.VOLLEY_BRAWL

/**
 * Checks whether it is a "Duels" event mode.
 * @see EventMode.Companion.DUELS
 */
public val EventMode.isDuels: Boolean
    get() = this == EventMode.DUELS

/**
 * Checks whether it is a "Wipeout" event mode.
 * @see EventMode.Companion.WIPEOUT
 */
public val EventMode.isWipeout: Boolean get() = this == EventMode.WIPEOUT

/**
 * Checks whether it is a "Payload" event mode.
 * @see EventMode.Companion.PAYLOAD
 */
public val EventMode.isPayload: Boolean get() = this == EventMode.PAYLOAD

/**
 * Checks whether it is a "Bot Drop" event mode.
 * @see EventMode.Companion.BOT_DROP
 */
public val EventMode.isBotDrop: Boolean get() = this == EventMode.BOT_DROP

/**
 * Checks whether it is a "Hunters" event mode.
 * @see EventMode.Companion.HUNTERS
 */
public val EventMode.isHunters: Boolean get() = this == EventMode.HUNTERS

/**
 * Checks whether it is a "Last Stand" event mode.
 * @see EventMode.Companion.LAST_STAND
 */
public val EventMode.isLastStand: Boolean get() = this == EventMode.LAST_STAND

/**
 * Checks whether it is a "Wipeout 5v5" event mode.
 * @see EventMode.Companion.WIPEOUT_5V5
 */
public val EventMode.isWipeout5v5: Boolean get() = this == EventMode.WIPEOUT_5V5

/**
 * Checks whether it is a "Brawl Ball 5v5" event mode.
 * @see EventMode.Companion.BRAWL_BALL_5V5
 */
public val EventMode.isBrawlBall5v5: Boolean get() = this == EventMode.BRAWL_BALL_5V5

/**
 * Checks whether it is a "Gem Grab 5v5" event mode.
 * @see EventMode.Companion.GEM_GRAB_5V5
 */
public val EventMode.isGemGrab5v5: Boolean get() = this == EventMode.GEM_GRAB_5V5

/**
 * Checks whether it is a "Trophy Escape" event mode.
 * @see EventMode.Companion.TROPHY_ESCAPE
 */
public val EventMode.isTrophyEscape: Boolean get() = this == EventMode.TROPHY_ESCAPE

/**
 * Checks whether it is a "Knockout 5v5" event mode.
 * @see EventMode.Companion.KNOCKOUT_5V5
 */
public val EventMode.isKnockout5v5: Boolean get() = this == EventMode.KNOCKOUT_5V5

/**
 * Checks whether it is a "Godzilla City Smash" event mode.
 * @see EventMode.Companion.GODZILLA_CITY_SMASH
 */
public val EventMode.isGodzillaCitySmash: Boolean get() = this == EventMode.GODZILLA_CITY_SMASH

/**
 * Checks whether it is a "Paint Brawl" event mode.
 * @see EventMode.Companion.PAINT_BRAWL
 */
public val EventMode.isPaintBrawl: Boolean get() = this == EventMode.PAINT_BRAWL

/**
 * Checks whether it is a "Trio Showdown" event mode.
 * @see EventMode.Companion.TRIO_SHOWDOWN
 */
public val EventMode.isTrioShowdown: Boolean get() = this == EventMode.TRIO_SHOWDOWN

/**
 * Checks whether it is a "Drum Roll" event mode.
 * @see EventMode.Companion.DRUM_ROLL
 */
public val EventMode.isDrumRoll: Boolean get() = this == EventMode.DRUM_ROLL

/**
 * Checks whether it is a "Soul Collector" event mode.
 * @see EventMode.Companion.SOUL_COLLECTOR
 */
public val EventMode.isSoulCollector: Boolean get() = this == EventMode.SOUL_COLLECTOR

/**
 * Checks whether it is a "Cleaning Duty" event mode.
 * @see EventMode.Companion.CLEANING_DUTY
 */
public val EventMode.isCleaningDuty: Boolean get() = this == EventMode.CLEANING_DUTY

/**
 * Checks whether it is a "Solo Showdown Limbo" event mode.
 * @see EventMode.Companion.SOLO_SHOWDOWN_LIMBO
 */
public val EventMode.isSoloShowdownLimbo: Boolean get() = this == EventMode.SOLO_SHOWDOWN_LIMBO

/**
 * Checks whether it is a "Knockout Limbo" event mode.
 * @see EventMode.Companion.KNOCKOUT_LIMBO
 */
public val EventMode.isKnockoutLimbo: Boolean get() = this == EventMode.KNOCKOUT_LIMBO

/**
 * Checks whether it is a "Brawl Hockey" event mode.
 * @see EventMode.Companion.BRAWL_HOCKEY
 */
public val EventMode.isBrawlHockey: Boolean get() = this == EventMode.BRAWL_HOCKEY

/**
 * Checks whether it is a "Gem Grab 2v2" event mode.
 * @see EventMode.Companion.GEM_GRAB_2V2
 */
public val EventMode.isGemGrab2v2: Boolean get() = this == EventMode.GEM_GRAB_2V2

/**
 * Checks whether it is a "Special Delivery" event mode.
 * @see EventMode.Companion.SPECIAL_DELIVERY
 */
public val EventMode.isSpecialDelivery: Boolean get() = this == EventMode.SPECIAL_DELIVERY

/**
 * Checks whether it is a "Brawl Arena" event mode.
 * @see EventMode.Companion.BRAWL_ARENA
 */
public val EventMode.isBrawlArena: Boolean get() = this == EventMode.BRAWL_ARENA

/**
 * Checks whether it is a "Brawl Ball 2v2" event mode.
 * @see EventMode.Companion.BRAWL_BALL_2V2
 */
public val EventMode.isBrawlBall2v2: Boolean get() = this == EventMode.BRAWL_BALL_2V2

/**
 * Checks whether it is a "Knockout 2v2" event mode.
 * @see EventMode.Companion.KNOCKOUT_2V2
 */
public val EventMode.isKnockout2v2: Boolean get() = this == EventMode.KNOCKOUT_2V2

/**
 * Checks whether it is a "Hot Zone 2v2" event mode.
 * @see EventMode.Companion.HOT_ZONE_2V2
 */
public val EventMode.isHotZone2v2: Boolean get() = this == EventMode.HOT_ZONE_2V2

/**
 * Checks whether it is a "Basket Brawl 2v2" event mode.
 * @see EventMode.Companion.BASKET_BRAWL_2V2
 */
public val EventMode.isBasketBrawl2v2: Boolean get() = this == EventMode.BASKET_BRAWL_2V2

/**
 * Checks whether it is a "Brawl Hockey 2v2" event mode.
 * @see EventMode.Companion.BRAWL_HOCKEY_2V2
 */
public val EventMode.isBrawlHockey2v2: Boolean get() = this == EventMode.BRAWL_HOCKEY_2V2

/**
 * Checks whether it is a "Special Delivery 2v2" event mode.
 * @see EventMode.Companion.SPECIAL_DELIVERY_2V2
 */
public val EventMode.isSpecialDelivery2v2: Boolean get() = this == EventMode.SPECIAL_DELIVERY_2V2

/**
 * Checks whether it is a "Token Run" event mode.
 * @see EventMode.Companion.TOKEN_RUN
 */
public val EventMode.isTokenRun: Boolean get() = this == EventMode.TOKEN_RUN

/**
 * Checks whether it is a "Treasure Hunt" event mode.
 * @see EventMode.Companion.TREASURE_HUNT
 */
public val EventMode.isTreasureHunt: Boolean get() = this == EventMode.TREASURE_HUNT

/**
 * Checks whether it is a "Vip Hunt" event mode.
 * @see EventMode.Companion.VIP_HUNT
 */
public val EventMode.isVipHunt: Boolean get() = this == EventMode.VIP_HUNT

/**
 * Checks whether it is a "Samurai Smash" event mode.
 * @see EventMode.Companion.SAMURAI_SMASH
 */
public val EventMode.isSamuraiSmash: Boolean get() = this == EventMode.SAMURAI_SMASH

/**
 * Checks whether it is a "Oni Hunt" event mode.
 * @see EventMode.Companion.ONI_HUNT
 */
public val EventMode.isOniHunt: Boolean get() = this == EventMode.ONI_HUNT

/**
 * Checks whether it is a "Dodgebrawl" event mode.
 * @see EventMode.Companion.DODGEBRAWL
 */
public val EventMode.isDodgebrawl: Boolean get() = this == EventMode.DODGEBRAWL

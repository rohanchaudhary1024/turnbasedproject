class Style { //hello
    private Attack[] attacks; // makes attacks and reaction for style, put in array
    private Reaction[] reactions;
    private String name; //the name

    public Style(String a){ //initializes the move set for a specific style
        name = a;
        attacks = new Attack[5];
        reactions = new Reaction[4];

        if(a.equals("Boxing")){ /*JAB - 4 DMG, 90%, 2 STM, PUNCH
            CROSS - 10 DMG, 75%, 5 STM, PUNCH
            UPPERCUT- 20 DMG, 40%, 10 STM, PUNCH
            QUICKSTEP - 0 DMG, 100%, -5 STM , None
            FINISHER - 25 DMG, 65%, 13 STM, PUNCH

            SLIP - 1.3 DM, 30%, 3 STM, DODGE
            GUARD - 0.5, 0%, 7 STM, BLOCK
            DISENGAGE - 0.8 DM, 15%, 5 STM, DODGE
            DEMPSEY ROLL - 1.5 DM, 40%, 8 STM, DODGE

            */
            
            attacks[0] = new Attack("JAB",  4, 0.9, 2);
            attacks[1] = new Attack("CROSS",  10, 0.75, 5);
            attacks[2] = new Attack("UPPERCUT",  20, 0.4, 10);
            attacks[3] = new Attack("QUICKSTEP",  0, 1.0, -5);
            attacks[4] = new Attack("FINISHER", 25, 0.65, 13);

            reactions[0] = new Reaction("SLIP", 0.3, 1.3 ,3);
            reactions[1] = new Reaction("GUARD", 0.0, 0.5 ,7);
            reactions[2] = new Reaction("DISENGAGE", 0.15, 0.8 ,5);
            reactions[3] = new Reaction("DEMPSEY ROLL", 0.4, 1.5 ,8);
        }   

        else if(a.equals("Taekwondo")){/*
            LOW KICK - 6 DMG, 80%, 3 STM, KICK
            ROUNDHOUSE - 12 DMG, 70%, 6 STM, KICK
            CRESCENT KICK - 8 DMG, 80%, 9 STM, KICK
            FOREFIST - 3 DMG, 80%, 1 STM, PUNCH
            720 DEGREE KICK - 45 DMG, 50%, 20 STM, KICK

            WEDGE BLOCK - 0.8 DM, 10%, 3 STM
            RISING BLOCK COMBO - 0.6 DM, 20%, 7 STM
            SIDESTEP - 1, 20%, 4 STM
            COMPLETE MITIGATION - 0.4 DM, 60%, 15 STM

            */
            attacks[0] = new Attack("LOW KICK",  6, 0.9, 3);
            attacks[1] = new Attack("ROUNDHOUSE",  12, 0.75, 6);
            attacks[2] = new Attack("CRESCENT KICK",  8, 0.4, 9);
            attacks[3] = new Attack("FOREFIST",  3, 1.0, 1);
            attacks[4] = new Attack("720 DEGREE KICK", 45, 0.65, 20);

            reactions[0] = new Reaction("WEDGE BLOCK", 0.1, 0.8 ,3);
            reactions[1] = new Reaction("RISING BLOCK COMBO", 0.2, 0.6 ,7);
            reactions[2] = new Reaction("SIDESTEP", 0.2, 1 ,4);
            reactions[3] = new Reaction("COMPLETE MITIGATION", 0.6, 0.4 ,15);
        }

        else if(a.equals("Muay Thai")){/*
            KNEE STRIKE - 7 DMG, 80%, 8 STM, KICK
            SUPERMAN PUNCH - 9 DMG, 70%, 9 STM, KICK
            AXE KICK - 19 DMG, 50%, 14 STM, KICK
            ElBOW STRIKE - 13 DMG, 35%, 2 STM, PUNCH
            CLINCH STRIKE COMBO - 30 DMG, 60%, 20 STM, KICK

            SHIN BLOCK - 0.7 DM, 0%, 5 STM
            IRON WILL - 1.5 DM, 0%, -20 STM
            IRON SHIN MITIGATION - 0.4 DM, 0%, 13 STM
            FULL BODY MITIGATION - 0.2 DM, 0%, 20 STM

             */


            attacks[0] = new Attack("KNEE STRIKE",  7, 0.8, 8);
            attacks[1] = new Attack("SUPERMAN PUNCH",  9, 0.7, 9);
            attacks[2] = new Attack("AXE KICK",  19, 0.5, 14);
            attacks[3] = new Attack("ElBOW STRIKE",  13, 0.35, 2);
            attacks[4] = new Attack("CLINCH STRIKE COMBO", 30, 0.6, 20);

            reactions[0] = new Reaction("SHIN BLOCK", 0.0, 0.7 ,5);
            reactions[1] = new Reaction("IRON WILL", 0.0, 1.5 ,-20);
            reactions[2] = new Reaction("IRON SHIN MITIGATION", 0.0, 0.4 ,13);
            reactions[3] = new Reaction("FULL BODY MITIGATION", 0.0, 0.2 ,20);
        }

        else if(a.equals("Kung Fu")){/*
            EAGLE CLAW -20 DMG, 62%, 10 STM
            MONKEY PUNCH- 10 DMG, 80%, 5 STM
            BATTLE MEDITATION - 0 DMG, 100%, -12 STM
            URSINE SMASH - 40 DMG, 90%, 20 STM
            DRAGON PUNCH - 50 DMG, 20%, 21 STM
            
            SERPENT DODGE - 0.4 DM, 70%, 15 STM
            OX MITIGATION -  0.3 DM, 10%, 20 STM
            MUSCLE HARDENING -  0.2 DM, 0%, 20 STM
            THOUSAND HAND DODGE -  0.4 DM, 80%, 15 STM */
            attacks[0] = new Attack("EAGLE CLAW",  20, 0.62, 10);
            attacks[1] = new Attack("MONKEY PUNCH",  10, 0.8, 5);
            attacks[2] = new Attack("BATTLE MEDITATION",  0, 1.0, -12);
            attacks[3] = new Attack("URSINE SMASH",  40, 0.9, 20);
            attacks[4] = new Attack("DRAGON PUNCH", 50, 0.2, 21);

            reactions[0] = new Reaction("SERPENT DODGE", 0.70, 0.4,15);
            reactions[1] = new Reaction("OX MITIGATION", 0.1, 0.3 ,20);
            reactions[2] = new Reaction("MUSCLE HARDENING", 0.0, 0.2 ,20);
            reactions[3] = new Reaction("THOUSAND HAND DODGE", 0.8, 0.4 ,15);
        }

        else if(a.equals("Karate")){/*
            STRAIGHT PUNCH - 10 DMG, 78%, 6 STM
            CRESCENT KICK -12 DMG, 67%, 10 STM
            KNIFE CHOP - 20 DMG, 60%, 8 STM
            FLURRY ATTACK- 9 DMG, 90%, 5 STM
            POWER WORD: Hi--YAH- 25 DMG, 90%, 19 STM
            
            Reaction:
            LED BLOCK-  0.1 DM, 0%, 19 STM
            FLYING DODGE-  0.4 DM, 70%, 12 STM
            STRAFE DODGE -  0.4 DM, 80%, 17 STM
            STEEL ARM BLOCK -  0.8 DM, 0%, 21 STM */
            attacks[0] = new Attack("STRAIGHT PUNCH",  10, 0.78, 6);
            attacks[1] = new Attack("CRESCENT KICK",  12, 0.67, 10);
            attacks[2] = new Attack("KNIFE CHOP",  20, 0.67, 8);
            attacks[3] = new Attack("FLURRY ATTACK",  9, 0.6, 5);
            attacks[4] = new Attack("POWER WORD: Hi--YAH", 25, 0.9, 19);

            reactions[0] = new Reaction("LED BLOCK", 0.0, 0.1 ,19);
            reactions[1] = new Reaction("FLYING DODGE", 0.7, 0.4 ,12);
            reactions[2] = new Reaction("STRAFE DODGE", 0.8, 0.4 ,17);
            reactions[3] = new Reaction("STEEL ARM BLOCK", 0.0, 0.8 ,21);
        }

        else if(a.equals("Aikido")){ /*
            REDIRECT ENERGY’ - 10 DMG, 80%, 5 STM
            FLOWING KICK-11 DMG, 82%, 8 STM
            SHOULDER THROW - 20 DMG, 90%, 9 STM
            REST THROUGH BATTLE- 0 DMG, 100%, -10 STM
            FULL REDIRECTION- 35 DMG, 46%, 24 STM

            SHIFTING SAND LEG-  0.4 DM, 73%, 15 STM
            SLIDING DODGE - 0.6 DM, 81%, 15 STM
            ENERGY BLOCK -  0.2 DM, 0%, 13 STM
            REDIRECTION OF SELF - 0.8 DM, 98%, 10 STM
 */
            attacks[0] = new Attack("REDIRECT ENERGY",  10, 0.8, 5);
            attacks[1] = new Attack("FLOWING KICK",  11, 0.82, 8);
            attacks[2] = new Attack("SHOULDER THROW",  20, 0.9, 9);
            attacks[3] = new Attack("REST THROUGH BATTLE",  0, 1.0, -10);
            attacks[4] = new Attack("FULL REDIRECTION", 35, 0.46, 24);

            reactions[0] = new Reaction("SHIFTING SAND LEG", 0.73, 0.4 ,15);
            reactions[1] = new Reaction("SLIDING DODGE", 0.81, 0.6 ,15);
            reactions[2] = new Reaction("ENERGY BLOCK", 0.0, 0.2 ,13);
            reactions[3] = new Reaction("REDIRECTION OF SELF", 0.98, 0.8 ,10);
        }

        else if(a.equals("Jiu Jitsu")){/*
            SHOULDER THROW - 20 DMG, 74%, 12 STM
            CHOKEHOLD - 22 DMG, 67%, 19 STM
            FULL MOUNT - 10 DMG, 89%, 11 STM
            STRIKE - 15 DMG, 92%, 8 STM
            GI CHOKE- 33 DMG, 78%, 15 STM

            ELBOW BLOCK -  0.3 DM, 0%, 17 STM
            HARD BLOCK - 0.1,  0%, 20 STM
            PULL GUARD -  0.4 DM, 87%, 15 STM
            TRIANGLE COUNTER- 0.9 DM, 100%, 20 STM */
            attacks[0] = new Attack("SHOULDER THROW",  20, 0.74, 12);
            attacks[1] = new Attack("CHOKEHOLD",  22, 0.67, 19);
            attacks[2] = new Attack("FULL MOUNT",  10, 0.89, 11);
            attacks[3] = new Attack("STRIKE",  15, 0.92, 8);
            attacks[4] = new Attack("GI CHOKE", 33, 0.78, 15);

            reactions[0] = new Reaction("ELBOW BLOCK", 0.0, 0.3 ,17);
            reactions[1] = new Reaction("HARD BLOCK", 0.0, 0.1 ,20);
            reactions[2] = new Reaction("PULL GUARD", 0.87, 0.4 ,15);
            reactions[3] = new Reaction("TRIANGLE COUNTER", 1.0, 0.9 ,20);
        }

        else if(a.equals("Judo")){ /*
            FULL FLIP -  15 DMG, 87%, 17 STM
            SINGLE LEG SWEEP -22 DMG, 67%, 19 STM
            DOUBLE LEG SWEEP - 12 DMG, 88%, 11 STM
            TOMOE NAGAE- 10 DMG, 77%, 9 STM
            UCHI MATA- 33 DMG, 54%, 17 STM

            Reactions:
            QUICKSTEP DODGE- 0.7 DM, 67%, 9 STM
            LEG STOPPER-  0.7 DM, 85%, 15 STM
            BONE BREAKER-  0.2 DM, 80%, 15 STM
            FINAL COUNTERMEASURE - 0.4 DM, 87%, 17 STM */
            attacks[0] = new Attack("FULL FLIP",  15, 0.17, 17);
            attacks[1] = new Attack("SINGLE LEG SWEEP",  22, 0.67, 19);
            attacks[2] = new Attack("DOUBLE LEG SWEEP",  12, 0.88, 11);
            attacks[3] = new Attack("TOMOE NAGAE",  10, 0.77, 9);
            attacks[4] = new Attack("UCHI MATA", 33, 0.54, 17);

            reactions[0] = new Reaction("QUICKSTEP DODGE", 0.67, 0.7 ,9);
            reactions[1] = new Reaction("LEG STOPPER", 0.85, 0.7 ,15);
            reactions[2] = new Reaction("BONE BREAKER", 0.8, 0.2 ,15);
            reactions[3] = new Reaction("FINAL COUNTERMEASURE", 0.87, 0.4 ,17);
        }

        else if(a.equals("Драконая система")){/*
            OBLITERATE - 100 DMG, 100%, 49 STM
            TAIL OF THE DRAGON- 99 DMG, 100%, 50 STM
            ВСЕЛЕНСКИЙ ВЕЧНЫЙ ПЛАМЯ- 10 DMG, 100%, -49 STM
            Угроза ядерной бомбы- 300 DMG, 100%, 49 STM
            окончательный взрыв дракона 🐉🐉- 10000 DMG, 100%, 49 STM 

            Reaction
            INFERNO SCALES OF RUSSIA -  0.0 DM, 100%, 0 STM
            УНИВЕРСАЛЬНЫЕ СТУДИИ -  0.0 DM, 99%, 0 STM
            твоя слабая атака отстой -  0.0 DM, 100%, 0 STM
            ULTIMATE DODGE OF DRAGON-  0.5 DM, 1000%, 1 STM
             */
            attacks[0] = new Attack("OBLITERATE",  100, 1.0, 49);
            attacks[1] = new Attack("TAIL OF THE DRAGON",  99, 1.0, 50);
            attacks[2] = new Attack("ВСЕЛЕНСКИЙ ВЕЧНЫЙ ПЛАМЯ",  10, 1.0, -49);
            attacks[3] = new Attack("Угроза ядерной бомбы",  300, 1.0, 49);
            attacks[4] = new Attack("окончательный взрыв дракона 🐉🐉", 10000, 1.0, 49);

            reactions[0] = new Reaction("INFERNO SCALES OF RUSSIA", 1.0, 0.0 ,0);
            reactions[1] = new Reaction("УНИВЕРСАЛЬНЫЕ СТУДИИ", 0.99, 0.0 ,0);
            reactions[2] = new Reaction("твоя слабая атака отстой ", 1.0, 0.0 ,0);
            reactions[3] = new Reaction("ULTIMATE DODGE OF DRAGON", 10.0, 0.5 ,1);
        }

        else{
            name = "INVALID STYLE";
        }
        

        
    }

    public Attack[] getAttacks(){ // returns attack move array
        return attacks;
    }

    public Reaction[] getReactions(){ // returns reactions move array
        return reactions;
    }

    public String getName(){ // returns name
        return name;
    }

}


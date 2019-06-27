INSERT INTO
  races (id_race, name)
VALUES
  (1, 'Licorne'),
  (2, 'Poney terrestre'),
  (3, 'Pégase'),
  (4, 'Dragon'),
  (5, 'Griffon'),
  (6, 'Changelin'),
  (7, 'Yakyak'),
  (8, 'Chien de cristal');
INSERT INTO
  talents (id_talent, nom)
VALUES
  (1, 'Coeur vaillant'),
  (2, 'Domptage des nuages'),
  (3, 'Localisation'),
  (4, 'Poney polyvalent'),
  (5, 'Rayon étourdissant'),
  (6, 'Télékinésie'),
  (7, 'Téléportation'),
  (8, 'Vol'),
  (
    9,
    'Communication avec les animaux (Créatures myhtiques)'
  ),
  (
    10,
    'Communication avec les animaux (Insectes)'
  ),
  (
    11,
    'Communication avec les animaux (mammifères)'
  ),
  (
    12,
    'Communication avec les animaux (oiseaux)'
  ),
  (
    13,
    'Communication avec les animaux (poissons)'
  ),
  (
    14,
    'Communication avec les animaux (reptiles)'
  ),
  (15, 'Compétence spéciale (Course)'),
  (16, 'Compétence spéciale (Danse)'),
  (17, 'Compétence spéciale (Escalade)'),
  (18, 'Compétence spéciale (Furtivité)'),
  (19, 'Compétence spéciale (Jonglerie)'),
  (20, 'Compétence spéciale (Ruade)'),
  (21, 'Compétence spéciale (Saut)'),
  (23, 'Connaissance encyclopédique (Art)'),
  (24, 'Connaissance encyclopédique (Biologie)'),
  (25, 'Connaissance encyclopédique (Chimie)'),
  (26, 'Connaissance encyclopédique (Géographie)'),
  (27, 'Connaissance encyclopédique (Histoire)'),
  (
    28,
    'Connaissance encyclopédique (Connaissance de la magie)'
  ),
  (29, 'Connaissance encyclopédique (Mathématique)'),
  (30, 'Connaissance encyclopédique (Physique)'),
  (31, 'Connaissance encyclopédique (Lois)'),
  (32, 'Connaissance encyclopédique (Princesse)'),
  (33, 'Contact guérisseur'),
  (34, 'Créativite artistique(Boulangerie)'),
  (35, 'Créativite artistique(Comédie)'),
  (36, 'Créativite artistique(Tragédie)'),
  (37, 'Créativite artistique(Mode)'),
  (38, 'Créativite artistique(Musique)'),
  (39, 'Créativite artistique(Peinture)'),
  (40, 'Créativite artistique(Sculpture)'),
  (41, 'Créativite artistique(Fête)'),
  (42, 'Gros yeux'),
  (43, 'Instinct de poney');
INSERT INTO
  link_race_talent (id_race, id_talent)
VALUES
  (2, 1),
  (3, 2),
  (1, 3),
  (2, 4),
  (1, 5),
  (1, 6),
  (1, 7),
  (3, 8);
INSERT INTO
  tokens (id_token, token)
VALUES
  (1, 'Sunbeam'),
  (2, 'Music'),
  (3, 'Fizzy'),
  (4, 'Happy'),
  (5, 'Velvet'),
  (6, 'Magic'),
  (7, 'Feathers'),
  (8, 'Banana'),
  (9, 'Firefly'),
  (10, 'Wings'),
  (11, 'Cupid'),
  (12, 'Celestial'),
  (13, 'Almond'),
  (14, 'Emerald'),
  (15, 'Crescent'),
  (16, 'Strudel'),
  (17, 'Windy'),
  (18, 'Splashes'),
  (19, 'Spring'),
  (20, 'Harvest'),
  (21, 'Grape'),
  (22, 'Lime'),
  (23, 'Amethyst'),
  (24, 'Leaf'),
  (25, 'Cheery'),
  (26, 'Posey'),
  (27, 'Breezy'),
  (28, 'Bunny'),
  (29, 'Thunder'),
  (30, 'Cloudy'),
  (31, 'Afternoon'),
  (32, 'Red'),
  (33, 'Green'),
  (34, 'Silver'),
  (35, 'Gold'),
  (36, 'Hoove'),
  (37, 'Flash'),
  (38, 'Burst'),
  (39, 'Cape'),
  (40, 'Flame'),
  (41, 'Dragon'),
  (42, 'Griffon'),
  (43, 'Changelin'),
  (44, 'Yakyak'),
  (45, 'Chien de cristal'),
  (46, 'Doe');
INSERT INTO
  link_token_race (id_token, id_race)
VALUES
  (1, 1),
  (2, 1),
  (3, 1),
  (4, 1),
  (5, 1),
  (6, 1),
  (7, 1),
  (8, 1),
  (9, 1),
  (10, 1),
  (11, 1),
  (12, 1),
  (13, 1),
  (14, 1),
  (15, 1),
  (16, 1),
  (17, 1),
  (18, 1),
  (19, 1),
  (20, 1),
  (21, 1),
  (22, 1),
  (23, 1),
  (24, 1),
  (25, 1),
  (26, 1),
  (27, 1),
  (28, 1),
  (29, 1),
  (30, 1),
  (31, 1),
  (32, 1),
  (33, 1),
  (34, 1),
  (35, 1),
  (36, 1),
  (37, 1),
  (38, 1),
  (39, 1),
  (40, 1),
  (1, 2),
  (2, 2),
  (3, 2),
  (4, 2),
  (5, 2),
  (6, 2),
  (7, 2),
  (8, 2),
  (9, 2),
  (10, 2),
  (11, 2),
  (12, 2),
  (13, 2),
  (14, 2),
  (15, 2),
  (16, 2),
  (17, 2),
  (18, 2),
  (19, 2),
  (20, 2),
  (21, 2),
  (22, 2),
  (23, 2),
  (24, 2),
  (25, 2),
  (26, 2),
  (27, 2),
  (28, 2),
  (29, 2),
  (30, 2),
  (31, 2),
  (32, 2),
  (33, 2),
  (34, 2),
  (35, 2),
  (36, 2),
  (37, 2),
  (38, 2),
  (39, 2),
  (40, 2),
  (1, 3),
  (2, 3),
  (3, 3),
  (4, 3),
  (5, 3),
  (6, 3),
  (7, 3),
  (8, 3),
  (9, 3),
  (10, 3),
  (11, 3),
  (12, 3),
  (13, 3),
  (14, 3),
  (15, 3),
  (16, 3),
  (17, 3),
  (18, 3),
  (19, 3),
  (20, 3),
  (21, 3),
  (22, 3),
  (23, 3),
  (24, 3),
  (25, 3),
  (26, 3),
  (27, 3),
  (28, 3),
  (29, 3),
  (30, 3),
  (31, 3),
  (32, 3),
  (33, 3),
  (34, 3),
  (35, 3),
  (36, 3),
  (37, 3),
  (38, 3),
  (39, 3),
  (40, 3),
  (41, 4),
  (42, 5),
  (43, 6),
  (44, 7),
  (45, 8),
  (46, 4),
  (46, 5),
  (46, 6),
  (46, 7),
  (46, 8);
INSERT INTO
  level (lvl, lvl_value)
VALUES
  (1, 'D4'),
  (2, 'D6'),
  (3, 'D8'),
  (4, 'D10'),
  (5, 'D12'),
  (6, 'D20');

INSERT INTO already_made (id,name, id_race,level, lvl_body, lvl_mind, lvl_charm, src) VALUES
 (1, 'Twilight Sparkle',1,11, 4,6,5, 'http://images.adagio.com/images2/custom_blends/16854.jpg'),
 (2, 'Applejack',2,10, 6,5,4, 'http://images.adagio.com/images2/custom_blends/16857.jpg'),
 (3, 'Fluttershy',3,10, 4,4,6, 'http://images.adagio.com/images2/custom_blends/16853.jpg'),
 (4, 'Pinkie Pie',2,10, 5,4,6, 'http://images.adagio.com/images2/custom_blends/16858.jpg'),
 (5, 'Rarity',1,10, 3,5,6,'http://images.adagio.com/images2/custom_blends/16856.jpg'),
 (6, 'Rainbow Dash',3,10, 6,4,4, 'http://images.adagio.com/images2/custom_blends/16855.jpg');

INSERT INTO
  quirks (id_quirk, name_quirk)
VALUES
  (1, 'Allergie'),
  (2, 'Asthme'),
  (3, 'Autoritaire'),
  (4, 'Distrait'),
  (5, 'Etourdi'),
  (6, 'Hirsute'),
  (7, 'Loufoque'),
  (8, 'Lunettes'),
  (9, 'Maniaque'),
  (10, 'Manque de tact'),
  (11, 'Moimoimoimoimoi !'),
  (12, 'Naïf'),
  (13, 'Oooohh.. joli !'),
  (14, 'Phobie'),
  (15, 'Présomptueux'),
  (16, 'Suceptible'),
  (17, 'Ultra-timide');

INSERT INTO
  quirks_link_already_made (id_pony, id_quirk)
  VALUES
  (1,3),
  (2,10),
  (2,6),
  (3,17),
  (3,14),
  (4,12),
  (4,7),
  (5,9),
  (5,14),
  (6,11),
  (6,15);
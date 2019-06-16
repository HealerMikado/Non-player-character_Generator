INSERT INTO
  races (id_race, nom)
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
  (40, 'Flame');

  INSERT INTO level (lvl, lvl_value) VALUES
  (1, 'D4'),
  (2, 'D6'),
  (3, 'D8'),
  (4, 'D10'),
  (5, 'D12'),
  (6, 'D20');
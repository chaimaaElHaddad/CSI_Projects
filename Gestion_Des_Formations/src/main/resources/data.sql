

INSERT INTO `users` VALUES (1,'Jamaa Mezouak, Tétouan','chaimaahaddad7@gmail.com','ElHaddad','$2a$10$USCtXq867sTfBTIA/GmGtemqQZE29.JJHYywXL3OX4VQt2uGQBVJO','0636954339','Chaimaa','BENEFICIAIRE','Chaimaa ElHaddad'),(2,'Jamaa Mezouak, Tétouan','sarah.zoumhan@gmail.com','Zoumhan','sara','06','Sara','Sara Zoumhan','BENEFICIAIRE'),(3,'Akba Halouf, Tétouan','intissar.harras@gmail.com','Harras','intissar','06','Intissar','Intissar Harras','BENEFICIAIRE'),(4,'Wllah Man3raf','naanai@gmail.com','Naanai','naanai','06','Na3na3','Naanai','FORMATEUR');

INSERT INTO `curriculum_vitae` VALUES (1,4);

INSERT INTO `formation` VALUES (1,'Faculté des sciences de Tétouan','2020-04-02 00:00:00.000000','formation1','formation1',20,'objectif1 , objectif2','prerequis1',300,4);

INSERT INTO `element_de_formation` VALUES (1,'2020-04-02','element 1','element 1','objectif 1','prerequis1 , prerequis 2',100,60,1),(2,'2020-04-03','element 2','element 2','objectif 2','element 1',200,120,1);

INSERT INTO `evaluation` VALUES (1,1,0),(2,2,0);

INSERT INTO `evaluation_accueil_criteres` VALUES (1,10,'Espace de travail'),(1,5,'Matériel'),(1,20,'Propreté');

INSERT INTO `evaluation_contenu_criteres` VALUES (1,10,'L\'atteinte des objectifs de la formation'),(1,20,'L\'intérêt du sujet de formation');

INSERT INTO `evaluation_formateur_criteres` VALUES (1,15,'Compétence'),(1,20,'Disponibilité'),(1,15,'Façon d\'expliquer'),(1,15,'Gentillesse'),(1,20,'Maitrise du sujet');

INSERT INTO `user_element_inscription` VALUES ('2020-03-29 00:00:00.000000','intissar.harras@gmail.com',NULL,'077',1,3,NULL), ('2020-03-27 00:00:00.000000','chaimaahaddad7@gmail.com',NULL,'0636954339',1,1,NULL), ('2020-03-28 00:00:00.000000','sarah.zoumhan@gmail.com',NULL,'077',1,2,NULL);

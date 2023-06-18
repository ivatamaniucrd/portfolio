set dateformat ymd
use master
go
if exists(select 'True' from sys.databases where name='MT')
begin
alter database MT set single_user with rollback immediate
  drop database MT
  end
go
Create database MT
go 
Alter authorization on database ::MT to sa 
use MT
CREATE TABLE Agenti (
  Cod_Agent int PRIMARY KEY identity(1,1),
  Nume_Agent varchar(50) NOT NULL,
  Data_Nastere date NOT NULL,
  Data_Angajarii date NOT NULL,
  Salariu int NOT NULL,
  Sex varchar(10) NOT NULL,
  Adresa varchar(100) NOT NULL
);
GO
-- Tabela "Materiale"

CREATE TABLE Materiale (
  Cod_Material int PRIMARY KEY identity(1,1),
  Denumire varchar(50) NOT NULL,
  Stoc int NOT NULL,
  Pret int NOT NULL
);
GO
-- Tabela "Transporturi"

CREATE TABLE Transporturi (
  Cod_Transport int PRIMARY KEY identity(1,1),
  Data_Livrare date NOT NULL,
  Cantitate int NOT NULL,
  Cod_Agent int ,
  Cod_Material int ,
  FOREIGN KEY (Cod_Agent) REFERENCES Agenti(Cod_Agent),
  FOREIGN KEY (Cod_Material) REFERENCES Materiale(Cod_Material)
);
GO
-- Tabela "Agenti_Exclusi"

CREATE TABLE Agenti_Exclusi (
  Cod_Agent int PRIMARY KEY identity(1,1),
  Nume_Agent varchar(50) NOT NULL,
  Data_Excludere date NOT NULL,
  Motiv_Excludere varchar(100) NOT NULL
);
GO
-- Tabela "Utilizatori"

CREATE TABLE Utilizatori (
  Cod_Utilizator int PRIMARY KEY identity(1,1),
  Nume_Utilizator varchar(50) NOT NULL,
  Parola varchar(50) NOT NULL,
  Tip_Utilizator varchar(50) NOT NULL
);
GO
INSERT INTO Agenti (Nume_Agent, Data_Nastere, Data_Angajarii, Salariu, Sex, Adresa)
VALUES
( 'Ion Popescu', '1955-01-01', '2010-05-01', 5000, 'M', 'Str. Victoriei, nr. 1'),
( 'Maria Ionescu', '1938-03-15', '2012-03-01', 4500, 'F', 'Str. Libertatii, nr. 10'),
('Andrei Popa', '1990-07-05', '2015-01-01', 5500, 'M', 'Str. Mihai Eminescu, nr. 25'),
('Ana Munteanu', '1993-11-21', '2018-05-01', 6000, 'F', 'Str. Stefan cel Mare, nr. 12'),
('Mihai Radu', '1986-06-10', '2011-02-01', 4800, 'M', 'Str. Gheorghe Doja, nr. 8'),
('Cristina Stoica', '1911-12-01', '2016-01-01', 5200, 'F', 'Str. Avram Iancu, nr. 34'),
('Alexandru Tudor', '1989-09-18', '2014-07-01', 5300, 'M', 'Str. Cuza Voda, nr. 15'),
('Elena Dumitrescu', '1994-04-05', '2019-03-01', 6200, 'F', 'Str. Ion Creanga, nr. 21'),
('George Pop', '1987-02-14', '2012-09-01', 4700, 'M', 'Str. Stefan cel Mare, nr. 5'),
('Ana Maria Petrescu', '1992-10-02', '2017-04-01', 5700, 'F', 'Str. Tudor Vladimirescu, nr. 18');
GO

INSERT INTO Materiale (Denumire, Stoc, Pret)
VALUES ('Beton', 1000, 100),
('Fier beton', 2000, 200),
('Caramida', 5000, 50),
('Placi OSB', 1500, 80),
('Polistiren', 800, 70),
('Vopsea lavabila', 1200, 30),
('Gresie', 3000, 60),
('Faianta', 2500, 70),
('Lemn de constructii', 1800, 120),
('Geam termopan', 1000, 150);


GO
INSERT INTO Transporturi (Data_Livrare, Cantitate, Cod_Agent, Cod_Material)
VALUES 
('2023-05-13', 100, 1, 2),
('2023-05-14', 50, 2, 3),
('2023-05-15', 75, 3, 4),
('2023-05-16', 200, 4, 5),
('2023-05-17', 120, 5, 6),
('2023-05-18', 90, 6, 7),
('2023-05-19', 40, 7, 8),
('2023-04-20', 150, 8, 9),
('2023-04-21', 80, 9, 10),
('2023-04-22', 50, 10, 1),
('2023-04-23', 100, 1, 3),
('2023-03-24', 50, 2, 4),
('2023-04-25', 75, 3, 5),
('2023-04-26', 200, 4, 6),
('2023-04-27', 120, 5, 7),
('2023-04-28', 90, 6, 8),
('2023-04-29', 40, 7, 9),
('2023-04-30', 150, 8, 10),
('2023-03-31', 80, 9, 1),
('2023-03-01', 50, 10, 2),
('2023-03-02', 100, 1, 3),
('2023-03-03', 50, 2, 4),
('2023-03-04', 75, 3, 5),
('2023-03-05', 200, 4, 6),
('2023-03-06', 120, 5, 7),
('2023-03-07', 90, 6, 8),
('2023-03-08', 40, 7, 9),
('2023-03-09', 150, 8, 10),
('2023-03-10', 80, 9, 1),
('2023-03-11', 50, 10, 2),
('2023-03-12', 100, 1, 4),
('2023-03-13', 50, 2, 5),
('2023-03-14', 75, 3, 6),
('2023-03-15', 200, 4, 7),
('2023-03-16', 120, 5, 8),
('2023-03-17', 90, 6, 9),
('2023-03-18', 40, 7, 10),
('2023-03-19', 150, 8, 1),
('2023-03-20', 80, 9, 2),
('2023-03-21', 50, 10, 3)


GO
INSERT INTO Agenti_Exclusi (Nume_Agent, Data_Excludere, Motiv_Excludere)
VALUES ('Marcel Ionescu', '2023-04-01', 'Incetare contract de comun acord'),
('Adriana Popescu', '2023-04-15', 'Incompatibilitate cu pozitia ocupata'),
('Ciprian Mihai', '2023-05-01', 'Fapte de coruptie'),
('Andreea Radulescu', '2023-05-01', 'Incetare contract de comun acord'),
('Razvan Tudor', '2023-05-02', 'Incompatibilitate cu pozitia ocupata'),
('Ana-Maria Dumitru', '2023-05-02', 'Fapte de coruptie'),
('Vladimir Ionescu', '2023-05-02', 'Incetare contract de comun acord'),
('Diana Pop', '2023-05-02', 'Incompatibilitate cu pozitia ocupata'),
('Alexandru Georgescu', '2023-05-02', 'Fapte de coruptie'),
('Maria-Alexandra Stoica', '2023-05-02', 'Incetare contract de comun acord');
GO

INSERT INTO Utilizatori (Nume_Utilizator, Parola, Tip_Utilizator)
VALUES ('admin', 'admin123', 'Administrator'),
('user1', 'user123', 'Utilizator obisnuit'),
('user2', 'user456', 'Utilizator obisnuit'),
('user3', 'user789', 'Utilizator obisnuit'),
('user4', 'userabc', 'Utilizator obisnuit'),
('user5', 'userdef', 'Utilizator obisnuit'),
('user6', 'userxyz', 'Utilizator obisnuit'),
('user7', 'usermno', 'Utilizator obisnuit'),
('user8', 'userpqr', 'Utilizator obisnuit'),
('user9', 'userstu', 'Utilizator obisnuit');
GO
SELECT a.Cod_Agent, a.Nume_Agent, AVG(m.Pret * t.Cantitate) AS Venit_mediu
FROM Agenti a
JOIN Transporturi t ON a.Cod_Agent = t.Cod_Agent
JOIN Materiale m ON t.Cod_Material = m.Cod_Material
GROUP BY a.Cod_Agent, a.Nume_Agent
ORDER BY a.Cod_Agent;
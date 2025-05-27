-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 27-05-2025 a las 03:02:11
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.0.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `matriculados`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `alumnoweb`
--

CREATE TABLE `alumnoweb` (
  `codiEstdWeb` int(11) NOT NULL,
  `ndniEstdWeb` varchar(50) NOT NULL,
  `appaEstdWeb` varchar(50) NOT NULL,
  `apmaEstdWeb` varchar(50) NOT NULL,
  `nombEstdWeb` varchar(50) NOT NULL,
  `fechNaciEstdWeb` date NOT NULL,
  `logiEstd` varchar(100) NOT NULL,
  `passEstd` varchar(500) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Volcado de datos para la tabla `alumnoweb`
--

INSERT INTO `alumnoweb` (`codiEstdWeb`, `ndniEstdWeb`, `appaEstdWeb`, `apmaEstdWeb`, `nombEstdWeb`, `fechNaciEstdWeb`, `logiEstd`, `passEstd`) VALUES
(1, '87654321', 'García', 'Pérez', 'Juan', '2000-05-15', 'jgarcia', '$2a$10$gIexNXzuVgVyaIaeBccvs.N1u2xvV64EBf9SnzCxXoXy//.Rz.7yG'),
(2, '12345678', 'López', 'Martínez', 'María', '1999-08-22', 'mlopez', '$2a$10$OlQworq597EefCctkwPkruhCLE1a.1n2srXHKL8A8GAmJv3f9oSSu'),
(3, '98765432', 'Rodríguez', 'Sánchez', 'Carlos', '2001-03-10', 'crodriguez', '$2a$10$x63MRNf/RhhiLjxtklFT3OEMBgz1ea/LiAUtrjvdE8Geq3S/HPFKK');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `alumnoweb`
--
ALTER TABLE `alumnoweb`
  ADD PRIMARY KEY (`codiEstdWeb`),
  ADD UNIQUE KEY `ndniEstdWeb` (`ndniEstdWeb`),
  ADD UNIQUE KEY `logiEstd` (`logiEstd`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `alumnoweb`
--
ALTER TABLE `alumnoweb`
  MODIFY `codiEstdWeb` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Waktu pembuatan: 04 Jun 2023 pada 09.31
-- Versi server: 10.4.27-MariaDB
-- Versi PHP: 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `kasir_pbo`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `BERAS`
--

CREATE TABLE `BERAS` (
  `idBeras` int(11) NOT NULL,
  `harga` int(11) NOT NULL,
  `satuan` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `BERAS`
--

INSERT INTO `BERAS` (`idBeras`, `harga`, `satuan`) VALUES
(1, 13000, 'KG'),
(3, 61500, 'Karung');

-- --------------------------------------------------------

--
-- Struktur dari tabel `MINYAK`
--

CREATE TABLE `MINYAK` (
  `idMinyak` int(11) NOT NULL,
  `harga` int(11) NOT NULL,
  `satuan` varchar(50) NOT NULL,
  `merk` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `MINYAK`
--

INSERT INTO `MINYAK` (`idMinyak`, `harga`, `satuan`, `merk`) VALUES
(2, 19000, 'Liter', 'Wings Food'),
(4, 25000, 'Liter', 'Bimoli');

-- --------------------------------------------------------

--
-- Struktur dari tabel `SEMBAKO`
--

CREATE TABLE `SEMBAKO` (
  `idSembako` int(11) NOT NULL,
  `nama` varchar(50) NOT NULL,
  `jenis` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `SEMBAKO`
--

INSERT INTO `SEMBAKO` (`idSembako`, `nama`, `jenis`) VALUES
(1, 'Beras Pandan Wangi', 'BERAS'),
(2, 'Minyak sedaap 1L', 'MINYAK'),
(3, 'Beras Anak Lanang', 'BERAS'),
(4, 'Minyak Bimoli 1L', 'MINYAK');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `BERAS`
--
ALTER TABLE `BERAS`
  ADD PRIMARY KEY (`idBeras`);

--
-- Indeks untuk tabel `MINYAK`
--
ALTER TABLE `MINYAK`
  ADD PRIMARY KEY (`idMinyak`);

--
-- Indeks untuk tabel `SEMBAKO`
--
ALTER TABLE `SEMBAKO`
  ADD PRIMARY KEY (`idSembako`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `SEMBAKO`
--
ALTER TABLE `SEMBAKO`
  MODIFY `idSembako` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Ketidakleluasaan untuk tabel pelimpahan (Dumped Tables)
--

--
-- Ketidakleluasaan untuk tabel `BERAS`
--
ALTER TABLE `BERAS`
  ADD CONSTRAINT `beras_ibfk_1` FOREIGN KEY (`idBeras`) REFERENCES `BARANG` (`idSembako`);

--
-- Ketidakleluasaan untuk tabel `MINYAK`
--
ALTER TABLE `MINYAK`
  ADD CONSTRAINT `minyak_ibfk_1` FOREIGN KEY (`idMinyak`) REFERENCES `SEMBAKO` (`idSembako`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

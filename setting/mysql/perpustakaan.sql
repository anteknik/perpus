-- phpMyAdmin SQL Dump
-- version 4.2.7.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Aug 07, 2015 at 03:32 PM
-- Server version: 5.6.20
-- PHP Version: 5.5.15

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `perpustakaan`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE IF NOT EXISTS `admin` (
  `id_admin` varchar(700) DEFAULT NULL,
  `password` varchar(700) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`id_admin`, `password`) VALUES
('•³þùDw×÷\Z«aÔ9Ç', 'ý{ÂÂhý—ÿÏú|Û[Ç');

-- --------------------------------------------------------

--
-- Table structure for table `anggota`
--

CREATE TABLE IF NOT EXISTS `anggota` (
  `no_anggota` varchar(10) NOT NULL,
  `nama_anggota` varchar(40) DEFAULT NULL,
  `tmp_lahir` varchar(20) DEFAULT NULL,
  `tgl_lahir` date DEFAULT NULL,
  `j_kel` char(1) DEFAULT NULL,
  `alamat` varchar(70) DEFAULT NULL,
  `no_telp` varchar(13) DEFAULT NULL,
  `email` varchar(25) DEFAULT NULL,
  `tgl_gabung` date DEFAULT NULL,
  `masa_berlaku` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `anggota`
--

INSERT INTO `anggota` (`no_anggota`, `nama_anggota`, `tmp_lahir`, `tgl_lahir`, `j_kel`, `alamat`, `no_telp`, `email`, `tgl_gabung`, `masa_berlaku`) VALUES
('A000000001', 'SUGENG RAHAYU WIDODO', 'MAGELANG', '1987-07-27', 'L', 'JL. SALAKAN 2 RT3 BANGUNHARJO SEWON BANTUL', '085643036571', 'sugeng_widodo32@yahoo.com', '2009-07-27', '2010-07-27'),
('A000000002', 'WINDIARTO', 'KLATEN', '1990-07-27', 'L', 'JL. MERGANGSAN 23 KARANGKAJEN DIY', '02746589468', 'adinda@yahoo.co.id', '2009-07-27', '2010-07-27'),
('A000000003', 'EDI PRASETYO', 'PURWOREJO', '1986-10-01', 'L', 'JL. MENUKAN 255 KARANGKAJEN DIY', '085643500086', 'pras_zhu@yahoo.com', '2009-07-27', '2010-07-27'),
('A000000004', 'TRI MULYANI', 'KARANGANYAR', '1986-10-22', 'P', 'JL. KARANGKUNTI 23 MERGANGSAN DIY', '0857894168', 'zahwanfairuzun@yahoo.com', '2009-07-27', '2010-07-27'),
('A000000005', 'Anton purwanto', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
('A000000006', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `bayar_denda`
--

CREATE TABLE IF NOT EXISTS `bayar_denda` (
  `tgl_denda` date NOT NULL DEFAULT '0000-00-00',
  `no_anggota` varchar(10) NOT NULL DEFAULT '',
  `no_inventaris` varchar(20) NOT NULL DEFAULT '',
  `kode_denda` char(5) NOT NULL DEFAULT '',
  `besar_denda` double DEFAULT NULL,
  `keterangan_denda` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `bayar_denda`
--

INSERT INTO `bayar_denda` (`tgl_denda`, `no_anggota`, `no_inventaris`, `kode_denda`, `besar_denda`, `keterangan_denda`) VALUES
('2009-07-29', 'A000000003', 'I000000008', 'D0001', 5000, '-'),
('2010-07-29', 'A000000003', 'I000000008', 'D0002', 20000, '-');

-- --------------------------------------------------------

--
-- Table structure for table `bayar_denda_harian`
--

CREATE TABLE IF NOT EXISTS `bayar_denda_harian` (
  `tgl_denda` date NOT NULL DEFAULT '0000-00-00',
  `no_anggota` varchar(10) NOT NULL DEFAULT '',
  `no_inventaris` varchar(20) NOT NULL DEFAULT '',
  `keterlambatan` char(4) DEFAULT NULL,
  `besar_denda` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `bayar_denda_harian`
--

INSERT INTO `bayar_denda_harian` (`tgl_denda`, `no_anggota`, `no_inventaris`, `keterlambatan`, `besar_denda`) VALUES
('2009-07-29', 'A000000001', 'I000000002', '1', 1000),
('2010-07-29', 'A000000001', 'I000000002', '1', 1000),
('2010-09-13', 'A000000002', 'I000000003', '2', 2000);

-- --------------------------------------------------------

--
-- Table structure for table `biodata_pegawai`
--

CREATE TABLE IF NOT EXISTS `biodata_pegawai` (
  `id_pegawai` varchar(10) NOT NULL,
  `nama_pegawai` varchar(20) DEFAULT NULL,
  `alamat_pegawai` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `buku`
--

CREATE TABLE IF NOT EXISTS `buku` (
  `kode_buku` varchar(10) NOT NULL DEFAULT '',
  `judul_buku` varchar(60) DEFAULT NULL,
  `jml_halaman` char(5) DEFAULT NULL,
  `kode_penerbit` varchar(10) DEFAULT NULL,
  `kode_pengarang` varchar(7) DEFAULT NULL,
  `thn_terbit` year(4) DEFAULT NULL,
  `isbn` varchar(20) DEFAULT NULL,
  `id_kategori` char(5) DEFAULT NULL,
  `id_jenis` char(5) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `buku`
--

INSERT INTO `buku` (`kode_buku`, `judul_buku`, `jml_halaman`, `kode_penerbit`, `kode_pengarang`, `thn_terbit`, `isbn`, `id_kategori`, `id_jenis`) VALUES
('B000000001', 'SETIA KEPADA CINTA', '231', 'PN00000003', 'P000006', 2002, '42342', 'K0006', 'J0002'),
('B000000002', 'TATA SURYA', '290', 'PN00000001', 'P000001', 2009, '5685', 'K0004', 'J0002'),
('B000000003', 'KEDAULTAN RAKYAT', '14', 'PN00000002', 'P000007', 2008, '0', 'K0011', 'J0005'),
('B000000004', 'TIP DAN TRIK BERBISNIS', '100', 'PN00000004', 'P000005', 1998, '121', 'K0009', 'J0001'),
('B000000005', 'MAHIR BERBAHASA INGGRIS', '324', 'PN00000003', 'P000003', 2000, '1242', 'K0004', 'J0002'),
('B000000006', 'BAHASA INDONESIA UNTUK ASING', '330', 'PN00000001', 'P000002', 1998, '1345', 'K0002', 'J0002'),
('B000000007', 'CERDAS CERMAT', '0', 'PN00000004', 'P000007', 2002, '0', 'K0011', 'J0004');

-- --------------------------------------------------------

--
-- Table structure for table `denda`
--

CREATE TABLE IF NOT EXISTS `denda` (
  `kode_denda` char(5) NOT NULL,
  `jenis_denda` varchar(20) DEFAULT NULL,
  `besar_denda` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `denda`
--

INSERT INTO `denda` (`kode_denda`, `jenis_denda`, `besar_denda`) VALUES
('D0001', 'HILANG', 20),
('D0002', 'RUSAK', 80);

-- --------------------------------------------------------

--
-- Table structure for table `inventaris`
--

CREATE TABLE IF NOT EXISTS `inventaris` (
  `no_inventaris` varchar(20) NOT NULL DEFAULT '',
  `kode_buku` varchar(10) DEFAULT NULL,
  `asal_buku` varchar(7) DEFAULT NULL,
  `tgl_pengadaan` date DEFAULT NULL,
  `harga` varchar(10) DEFAULT NULL,
  `status_buku` varchar(15) DEFAULT NULL,
  `kd_ruang` char(5) DEFAULT NULL,
  `no_rak` char(3) DEFAULT NULL,
  `no_box` char(3) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `inventaris`
--

INSERT INTO `inventaris` (`no_inventaris`, `kode_buku`, `asal_buku`, `tgl_pengadaan`, `harga`, `status_buku`, `kd_ruang`, `no_rak`, `no_box`) VALUES
('I000000001', 'B000000001', 'BELI', '2009-07-06', '25000', 'DIPINJAM', 'R0001', '04', '03'),
('I000000002', 'B000000002', 'BANTUAN', '2008-07-28', '15000', 'DIPINJAM', 'R0002', '05', '04'),
('I000000003', 'B000000003', 'HIBAH', '2003-07-28', '2000', 'DIPINJAM', 'R0001', '02', '04'),
('I000000004', 'B000000004', 'BELI', '2006-07-28', '30000', 'RUSAK', 'R0001', '03', '04'),
('I000000005', 'B000000005', 'BANTUAN', '2002-07-28', '20000', 'HILANG', 'R0001', '03', '03'),
('I000000006', 'B000000006', 'BELI', '2009-07-09', '24000', 'DIPINJAM', 'R0001', '03', '04'),
('I000000007', 'B000000007', 'BELI', '2009-07-28', '25000', 'DIPINJAM', 'R0002', '03', '04'),
('I000000008', 'B000000001', 'BELI', '2009-07-28', '25000', 'RUSAK', 'R0002', '01', '04');

-- --------------------------------------------------------

--
-- Table structure for table `jenis_buku`
--

CREATE TABLE IF NOT EXISTS `jenis_buku` (
  `id_jenis` char(5) NOT NULL,
  `nama_jenis` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `jenis_buku`
--

INSERT INTO `jenis_buku` (`id_jenis`, `nama_jenis`) VALUES
('J0001', 'MAJALAH'),
('J0002', 'BUKU'),
('J0003', 'MAKALAH'),
('J0004', 'VCD'),
('J0005', 'KORAN'),
('J0006', 'MEJA');

-- --------------------------------------------------------

--
-- Table structure for table `kategori`
--

CREATE TABLE IF NOT EXISTS `kategori` (
  `id_kategori` char(5) NOT NULL,
  `nama_kategori` varchar(25) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `kategori`
--

INSERT INTO `kategori` (`id_kategori`, `nama_kategori`) VALUES
('K0001', 'FISIKA'),
('K0002', 'BAHASA INDONESIA'),
('K0003', 'PEMROGRAMAN'),
('K0004', 'BAHASA INGGRIS'),
('K0005', 'BAHASA DAERAH'),
('K0006', 'CERITA ATAU NOVEL'),
('K0007', 'KIMIA'),
('K0008', 'MATEMATIKA'),
('K0009', 'EKONOMI'),
('K0010', 'SEJARAH'),
('K0011', 'BERITA ATAU INFORMASI');

-- --------------------------------------------------------

--
-- Table structure for table `peminjaman`
--

CREATE TABLE IF NOT EXISTS `peminjaman` (
  `no_anggota` varchar(10) DEFAULT NULL,
  `no_inventaris` varchar(20) DEFAULT NULL,
  `tgl_pinjam` date DEFAULT NULL,
  `tgl_kembali` date DEFAULT NULL,
  `nip` varchar(10) DEFAULT NULL,
  `status_pinjam` char(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `peminjaman`
--

INSERT INTO `peminjaman` (`no_anggota`, `no_inventaris`, `tgl_pinjam`, `tgl_kembali`, `nip`, `status_pinjam`) VALUES
('A000000002', 'I000000002', '2010-09-20', '2010-09-20', '0000000002', '1'),
('A000000001', 'I000000003', '2010-09-20', '0000-00-00', '0000000003', '0'),
('A000000001', 'I000000001', '2010-09-20', '2010-09-20', '0000000002', '1'),
('A000000002', 'I000000002', '2010-09-20', '0000-00-00', '0000000002', '0'),
('A000000002', 'I000000007', '2010-09-20', '0000-00-00', '0000000002', '0'),
('A000000001', 'I000000001', '2010-09-20', '0000-00-00', '0000000002', '0');

-- --------------------------------------------------------

--
-- Table structure for table `penerbit`
--

CREATE TABLE IF NOT EXISTS `penerbit` (
  `kode_penerbit` varchar(10) NOT NULL,
  `nama_penerbit` varchar(40) DEFAULT NULL,
  `alamat_penerbit` varchar(70) DEFAULT NULL,
  `no_telp` varchar(13) DEFAULT NULL,
  `email` varchar(25) DEFAULT NULL,
  `website_penerbit` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `penerbit`
--

INSERT INTO `penerbit` (`kode_penerbit`, `nama_penerbit`, `alamat_penerbit`, `no_telp`, `email`, `website_penerbit`) VALUES
('PN00000001', 'GAVA MEDIA', 'JL. KRAPYAK BARAT 32 YOGYAKARTA', '02745756', 'gava@media.com', 'www.media.com'),
('PN00000002', 'GRAMEDIA', 'JL. DI PANJAITAN 32', '0274638623', 'gramedia@yahoo.com', 'gramedia.blogspor.com'),
('PN00000003', 'ARIPHOLIC', 'JL. KOTA GEDE 23 KOTA GEDE DIY', '027463862', 'aripholic@yahoo.com', 'aripholic.co.cc'),
('PN00000004', 'TRI SAKTI', 'JL. MENJANGAN 90 KALIURANG DIY', '027438563', 'admin@trisakti.com', 'www.trisakti.com');

-- --------------------------------------------------------

--
-- Table structure for table `pengarang`
--

CREATE TABLE IF NOT EXISTS `pengarang` (
  `kode_pengarang` varchar(7) NOT NULL,
  `nama_pengarang` varchar(40) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pengarang`
--

INSERT INTO `pengarang` (`kode_pengarang`, `nama_pengarang`) VALUES
('P000001', 'JOGIYANTO'),
('P000002', 'MUHAMMAD GUFRON'),
('P000003', 'ABDUL AZZIS'),
('P000004', 'MARDIYANTA'),
('P000005', 'M. SUYANTO'),
('P000006', 'HENDARMAN SUCAHYO'),
('P000007', 'TANPA PENGARANG');

-- --------------------------------------------------------

--
-- Table structure for table `petugas`
--

CREATE TABLE IF NOT EXISTS `petugas` (
  `nip` varchar(10) NOT NULL,
  `nama_petugas` varchar(40) DEFAULT NULL,
  `tmp_lahir` varchar(20) DEFAULT NULL,
  `tgl_lahir` date DEFAULT NULL,
  `j_kel` char(1) DEFAULT NULL,
  `alamat` varchar(70) DEFAULT NULL,
  `no_telp` varchar(13) DEFAULT NULL,
  `email` varchar(25) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `petugas`
--

INSERT INTO `petugas` (`nip`, `nama_petugas`, `tmp_lahir`, `tgl_lahir`, `j_kel`, `alamat`, `no_telp`, `email`) VALUES
('0000000001', 'DESY ARYANI', 'JAKARTA', '1988-07-05', 'P', 'JL. NITIKAN 32 YOGYAKARTA', '085674589646', 'desy_aryani@yahoo.com'),
('0000000002', 'DEN BAGUS NGARSO', 'YOGYAKARTA', '1980-02-14', 'L', 'JL. BUGISAN 12 KULON PROGO DIY', '08189765865', 'denngarso@gmail.com'),
('0000000003', 'HERLINA CELITA', 'BANDUNG', '1987-07-31', 'P', 'JL. SISINGAMANGARAJA  76 KARANGKAJEN YOGYAKARTA', '027457965', 'lina@yahoo.co.id');

-- --------------------------------------------------------

--
-- Table structure for table `ruang`
--

CREATE TABLE IF NOT EXISTS `ruang` (
  `kd_ruang` char(5) NOT NULL DEFAULT '',
  `nm_ruang` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ruang`
--

INSERT INTO `ruang` (`kd_ruang`, `nm_ruang`) VALUES
('R0001', 'PERPUSTAKAAN 1'),
('R0002', 'PERPUSTAKAAN 2');

-- --------------------------------------------------------

--
-- Table structure for table `setting`
--

CREATE TABLE IF NOT EXISTS `setting` (
  `nama_instansi` varchar(120) DEFAULT NULL,
  `alamat_instansi` varchar(120) DEFAULT NULL,
  `kabupaten` varchar(30) DEFAULT NULL,
  `propinsi` varchar(30) DEFAULT NULL,
  `wallpaper` varchar(200) DEFAULT NULL,
  `aktifkan` char(3) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `setting`
--

INSERT INTO `setting` (`nama_instansi`, `alamat_instansi`, `kabupaten`, `propinsi`, `wallpaper`, `aktifkan`) VALUES
('Anan.Software', '081210390406', '', '', '', '');

-- --------------------------------------------------------

--
-- Table structure for table `set_peminjaman`
--

CREATE TABLE IF NOT EXISTS `set_peminjaman` (
  `max_pinjam` int(11) DEFAULT NULL,
  `lama_pinjam` int(11) DEFAULT NULL,
  `denda_perhari` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `set_peminjaman`
--

INSERT INTO `set_peminjaman` (`max_pinjam`, `lama_pinjam`, `denda_perhari`) VALUES
(2, 7, 1000);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE IF NOT EXISTS `user` (
  `nip` varchar(10) NOT NULL,
  `password` varchar(700) DEFAULT NULL,
  `jenis_koleksi` char(3) DEFAULT NULL,
  `kategori_koleksi` char(3) DEFAULT NULL,
  `ruang` char(3) DEFAULT NULL,
  `denda` char(3) DEFAULT NULL,
  `pengarang` char(3) DEFAULT NULL,
  `petugas` char(3) DEFAULT NULL,
  `anggota` char(3) DEFAULT NULL,
  `penerbit` char(3) DEFAULT NULL,
  `koleksi` char(3) DEFAULT NULL,
  `inventaris` char(3) DEFAULT NULL,
  `bayar_denda` char(3) DEFAULT NULL,
  `sirkulasi` char(3) DEFAULT NULL,
  `setup_pinjam` char(3) DEFAULT NULL,
  `setup_aplikasi` char(3) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`nip`, `password`, `jenis_koleksi`, `kategori_koleksi`, `ruang`, `denda`, `pengarang`, `petugas`, `anggota`, `penerbit`, `koleksi`, `inventaris`, `bayar_denda`, `sirkulasi`, `setup_pinjam`, `setup_aplikasi`) VALUES
('0000000001', 'Ÿ“ö´¾­Á×\rª<÷ö1u‡', 'NO', 'NO', 'NO', 'NO', 'NO', 'NO', 'NO', 'NO', 'NO', 'NO', 'NO', 'NO', 'NO', 'NO'),
('0000000002', 'Ÿ“ö´¾­Á×\rª<÷ö1u‡', 'NO', 'NO', 'NO', 'NO', 'NO', 'NO', 'NO', 'NO', 'NO', 'NO', 'NO', 'NO', 'NO', 'NO');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `anggota`
--
ALTER TABLE `anggota`
 ADD PRIMARY KEY (`no_anggota`);

--
-- Indexes for table `bayar_denda`
--
ALTER TABLE `bayar_denda`
 ADD PRIMARY KEY (`tgl_denda`,`no_anggota`,`no_inventaris`,`kode_denda`), ADD KEY `kode_denda` (`kode_denda`), ADD KEY `no_anggota` (`no_anggota`), ADD KEY `no_inventaris` (`no_inventaris`);

--
-- Indexes for table `bayar_denda_harian`
--
ALTER TABLE `bayar_denda_harian`
 ADD PRIMARY KEY (`tgl_denda`,`no_anggota`,`no_inventaris`), ADD KEY `no_anggota` (`no_anggota`), ADD KEY `no_inventaris` (`no_inventaris`);

--
-- Indexes for table `biodata_pegawai`
--
ALTER TABLE `biodata_pegawai`
 ADD PRIMARY KEY (`id_pegawai`);

--
-- Indexes for table `buku`
--
ALTER TABLE `buku`
 ADD PRIMARY KEY (`kode_buku`), ADD KEY `kode_penerbit` (`kode_penerbit`), ADD KEY `kode_pengarang` (`kode_pengarang`), ADD KEY `id_kategori` (`id_kategori`), ADD KEY `id_jenis` (`id_jenis`);

--
-- Indexes for table `denda`
--
ALTER TABLE `denda`
 ADD PRIMARY KEY (`kode_denda`);

--
-- Indexes for table `inventaris`
--
ALTER TABLE `inventaris`
 ADD PRIMARY KEY (`no_inventaris`), ADD KEY `kode_buku` (`kode_buku`), ADD KEY `kd_ruang` (`kd_ruang`);

--
-- Indexes for table `jenis_buku`
--
ALTER TABLE `jenis_buku`
 ADD PRIMARY KEY (`id_jenis`);

--
-- Indexes for table `kategori`
--
ALTER TABLE `kategori`
 ADD PRIMARY KEY (`id_kategori`);

--
-- Indexes for table `peminjaman`
--
ALTER TABLE `peminjaman`
 ADD KEY `no_anggota` (`no_anggota`), ADD KEY `no_inventaris` (`no_inventaris`), ADD KEY `nip` (`nip`);

--
-- Indexes for table `penerbit`
--
ALTER TABLE `penerbit`
 ADD PRIMARY KEY (`kode_penerbit`);

--
-- Indexes for table `pengarang`
--
ALTER TABLE `pengarang`
 ADD PRIMARY KEY (`kode_pengarang`);

--
-- Indexes for table `petugas`
--
ALTER TABLE `petugas`
 ADD PRIMARY KEY (`nip`);

--
-- Indexes for table `ruang`
--
ALTER TABLE `ruang`
 ADD PRIMARY KEY (`kd_ruang`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
 ADD PRIMARY KEY (`nip`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `bayar_denda`
--
ALTER TABLE `bayar_denda`
ADD CONSTRAINT `bayar_denda_ibfk_1` FOREIGN KEY (`no_anggota`) REFERENCES `anggota` (`no_anggota`) ON UPDATE CASCADE,
ADD CONSTRAINT `bayar_denda_ibfk_2` FOREIGN KEY (`no_inventaris`) REFERENCES `inventaris` (`no_inventaris`) ON UPDATE CASCADE,
ADD CONSTRAINT `bayar_denda_ibfk_3` FOREIGN KEY (`kode_denda`) REFERENCES `denda` (`kode_denda`) ON UPDATE CASCADE;

--
-- Constraints for table `bayar_denda_harian`
--
ALTER TABLE `bayar_denda_harian`
ADD CONSTRAINT `bayar_denda_harian_ibfk_1` FOREIGN KEY (`no_anggota`) REFERENCES `anggota` (`no_anggota`) ON UPDATE CASCADE,
ADD CONSTRAINT `bayar_denda_harian_ibfk_2` FOREIGN KEY (`no_inventaris`) REFERENCES `inventaris` (`no_inventaris`) ON UPDATE CASCADE;

--
-- Constraints for table `buku`
--
ALTER TABLE `buku`
ADD CONSTRAINT `buku_ibfk_1` FOREIGN KEY (`kode_penerbit`) REFERENCES `penerbit` (`kode_penerbit`) ON UPDATE CASCADE,
ADD CONSTRAINT `buku_ibfk_2` FOREIGN KEY (`kode_pengarang`) REFERENCES `pengarang` (`kode_pengarang`) ON UPDATE CASCADE,
ADD CONSTRAINT `buku_ibfk_3` FOREIGN KEY (`id_kategori`) REFERENCES `kategori` (`id_kategori`) ON UPDATE CASCADE,
ADD CONSTRAINT `buku_ibfk_4` FOREIGN KEY (`id_jenis`) REFERENCES `jenis_buku` (`id_jenis`) ON UPDATE CASCADE;

--
-- Constraints for table `inventaris`
--
ALTER TABLE `inventaris`
ADD CONSTRAINT `inventaris_ibfk_1` FOREIGN KEY (`kode_buku`) REFERENCES `buku` (`kode_buku`) ON UPDATE CASCADE,
ADD CONSTRAINT `inventaris_ibfk_2` FOREIGN KEY (`kd_ruang`) REFERENCES `ruang` (`kd_ruang`) ON UPDATE CASCADE;

--
-- Constraints for table `peminjaman`
--
ALTER TABLE `peminjaman`
ADD CONSTRAINT `peminjaman_ibfk_1` FOREIGN KEY (`no_anggota`) REFERENCES `anggota` (`no_anggota`) ON UPDATE CASCADE,
ADD CONSTRAINT `peminjaman_ibfk_2` FOREIGN KEY (`no_inventaris`) REFERENCES `inventaris` (`no_inventaris`) ON UPDATE CASCADE,
ADD CONSTRAINT `peminjaman_ibfk_3` FOREIGN KEY (`nip`) REFERENCES `petugas` (`nip`) ON UPDATE CASCADE;

--
-- Constraints for table `user`
--
ALTER TABLE `user`
ADD CONSTRAINT `user_ibfk_1` FOREIGN KEY (`nip`) REFERENCES `petugas` (`nip`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

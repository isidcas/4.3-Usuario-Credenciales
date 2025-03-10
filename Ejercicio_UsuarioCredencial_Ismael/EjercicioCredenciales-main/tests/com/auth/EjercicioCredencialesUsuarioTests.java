package com.auth;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import ejercicioCredenciales.Usuario;

class EjercicioCredencialesUsuarioTests {

    private static Usuario usuario1;
    private static Usuario usuario2;
    private static Usuario usuario3;
    
    @BeforeAll
    public static void crearUsuarios() {
        usuario1 = new Usuario("Luis", "Pérez", "9uyhasv");
        usuario2 = new Usuario("Leo", "Messi", "leo.messi@hotmail.com", "kuhsfd");
        usuario3 = new Usuario("Carlos", "García", "9uyhasvV");
    }
    
    @Test
    void testEsCuentaBloqueadaDeUsuario1() {
        assertFalse(usuario1.esCuentaBloqueada());
        usuario1.hacerLogin("asdgf", "ags");
        usuario1.hacerLogin("asdgf", "ags");
        usuario1.hacerLogin("asdgf", "ags");
        assertTrue(usuario1.esCuentaBloqueada());
    }

    @Test
    void testEsPasswordModificable() {
        assertFalse(usuario1.modificarPassword("9uyhasv", "adios", "hola"));
        assertTrue(usuario2.modificarPassword("kuhsfd", "adios", "hola"));
        assertFalse(usuario2.modificarPassword("hola", "hola", "adios"));
        assertFalse(usuario2.modificarPassword("hola", "adios", "adios"));
        assertFalse(usuario2.modificarPassword("adios", "adios", "adios"));
    }

    @Test
    void testPasswordSegura() {
        assertTrue(usuario3.esPasswordSegura());
        assertFalse(usuario2.esPasswordSegura());
        assertFalse(usuario1.esPasswordSegura());
    } 
    
    @Test
    void testHacerLoginUsuario2() {
        
        assertTrue(usuario2.hacerLogin("LeoMessi100", "kuhsfd"));
        assertFalse(usuario2.hacerLogin("LeoMessi100", "1234"));
        assertFalse(usuario2.hacerLogin("LeoMessi100", null));
        
    }
}

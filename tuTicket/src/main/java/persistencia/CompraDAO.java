/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import peristencia.Interfaces.ICompraDAO;

/**
 *
 * @author melis
 */
public class CompraDAO  implements ICompraDAO {
    private final IConexionDB conexionDB;

    public CompraDAO(IConexionDB conexionDB) {
        this.conexionDB = conexionDB;
    }
}

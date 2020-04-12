package com.musicplayce.desafiopoker.model;

import lombok.Data;

@Data
public class Mesa 
{
	private Player player1;
	private Player player2;
	private int[]  hand1;
	private int[]  hand2;
	private String resultado;
}

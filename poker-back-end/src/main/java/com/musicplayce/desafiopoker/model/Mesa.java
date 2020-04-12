package com.musicplayce.desafiopoker.model;

import lombok.Data;

@Data
public class Mesa 
{
	private Player player;
	private int[]  hand;	
	private String resultado;
}

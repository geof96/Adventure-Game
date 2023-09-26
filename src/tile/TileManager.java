package tile;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TileManager {
    GamePanel gamePanel;
    Tile[] tile;
    int mapTileNum[] [];
    public TileManager(GamePanel gamePanel){
        this.gamePanel = gamePanel;
        tile = new Tile[10];
        mapTileNum = new int[gamePanel.maxScreenCol] [gamePanel.maxScreenRow];
        getTileImage();
        loadMap("/maps/map01.txt.txt");
    }
    public void getTileImage(){
        try {

            tile[0] = new Tile();
            tile[0].image = ImageIO.read(getClass().getResourceAsStream("/tiles/grass01.png"));

            tile[1] = new Tile();
            tile[1].image = ImageIO.read(getClass().getResourceAsStream("/tiles/wall.png"));

            tile[2] = new Tile();
            tile[2].image = ImageIO.read(getClass().getResourceAsStream("/tiles/water01.png"));

            tile[3] = new Tile();
            tile[3].image = ImageIO.read(getClass().getResourceAsStream("/tiles/earth.png"));


            tile[4] = new Tile();
            tile[4].image = ImageIO.read(getClass().getResourceAsStream("/tiles/tree.png"));


            tile[5] = new Tile();
            tile[5].image = ImageIO.read(getClass().getResourceAsStream("/tiles/sand.png"));



        }catch (IOException e){
            e.printStackTrace();
        }
    }


    public void loadMap(String filePath){
        try {

            InputStream is = getClass().getResourceAsStream(filePath);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            int col = 0;
            int row = 0;

            while(col < gamePanel.maxScreenCol && row < gamePanel.maxScreenRow){

                String line = br.readLine();
                while(col < gamePanel.maxScreenCol && row < gamePanel.maxScreenRow){
                    String numbers[] = line.split(" ");

                    int num = Integer.parseInt(numbers[col]);
                    mapTileNum[col] [row] = num;
                    col++;

                }
                if (col == gamePanel.maxScreenCol){
                    col = 0;
                    row++;
                }
            }
            br.close();
        }catch (Exception e){

        }





    }

    public void draw(Graphics2D g2){


        int col = 0;
        int row = 0;
        int x = 0;
        int y = 0;

        while (col < gamePanel.maxScreenCol && row < gamePanel.maxScreenRow){

            int tileNum = mapTileNum[col] [row];

            g2.drawImage(tile[tileNum].image, x, y, gamePanel.tileSize, gamePanel.tileSize, null);
            col++;
            x += gamePanel.tileSize;

            if (col == gamePanel.maxScreenCol){
                col = 0;
                x = 0;
                row++;
                y += gamePanel.tileSize;
            }
        }





/*        g2.drawImage(tile[1].image, 0, 0, gamePanel.tileSize, gamePanel.tileSize, null);
        g2.drawImage(tile[1].image, 48, 0, gamePanel.tileSize, gamePanel.tileSize, null);
        g2.drawImage(tile[1].image, 96, 0, gamePanel.tileSize, gamePanel.tileSize, null);
        g2.drawImage(tile[1].image, 144, 0, gamePanel.tileSize, gamePanel.tileSize, null);
        g2.drawImage(tile[1].image, 192, 0, gamePanel.tileSize, gamePanel.tileSize, null);

        g2.drawImage(tile[1].image, 0, 48, gamePanel.tileSize, gamePanel.tileSize, null);
        g2.drawImage(tile[0].image, 48, 48, gamePanel.tileSize, gamePanel.tileSize, null);
        g2.drawImage(tile[0].image, 96, 48, gamePanel.tileSize, gamePanel.tileSize, null);
        g2.drawImage(tile[0].image, 144, 48, gamePanel.tileSize, gamePanel.tileSize, null);
        g2.drawImage(tile[1].image, 192, 48, gamePanel.tileSize, gamePanel.tileSize, null);

        g2.drawImage(tile[1].image, 0, 96, gamePanel.tileSize, gamePanel.tileSize, null);
        g2.drawImage(tile[0].image, 48, 96, gamePanel.tileSize, gamePanel.tileSize, null);
        g2.drawImage(tile[0].image, 96, 96, gamePanel.tileSize, gamePanel.tileSize, null);
        g2.drawImage(tile[0].image, 144, 96, gamePanel.tileSize, gamePanel.tileSize, null);
        g2.drawImage(tile[0].image, 192, 96, gamePanel.tileSize, gamePanel.tileSize, null);

        g2.drawImage(tile[1].image, 0, 144, gamePanel.tileSize, gamePanel.tileSize, null);
        g2.drawImage(tile[0].image, 48, 144, gamePanel.tileSize, gamePanel.tileSize, null);
        g2.drawImage(tile[0].image, 96, 144, gamePanel.tileSize, gamePanel.tileSize, null);
        g2.drawImage(tile[0].image, 144, 144, gamePanel.tileSize, gamePanel.tileSize, null);
        g2.drawImage(tile[1].image, 192, 144, gamePanel.tileSize, gamePanel.tileSize, null);

        g2.drawImage(tile[1].image, 0, 192, gamePanel.tileSize, gamePanel.tileSize, null);
        g2.drawImage(tile[2].image, 49, 192, gamePanel.tileSize, gamePanel.tileSize, null);
        g2.drawImage(tile[2].image, 96, 192, gamePanel.tileSize, gamePanel.tileSize, null);
        g2.drawImage(tile[2].image, 144, 192, gamePanel.tileSize, gamePanel.tileSize, null);
        g2.drawImage(tile[1].image, 192, 192, gamePanel.tileSize, gamePanel.tileSize, null);*/
    }
}
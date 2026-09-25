package com.example.lightningtile;

import android.content.pm.PackageManager;
import android.service.quicksettings.Tile;
import android.service.quicksettings.TileService;

import rikka.shizuku.Shizuku;

public class LightningTileService extends TileService {

    @Override
    public void onStartListening() {
        super.onStartListening();

        Tile tile = getQsTile();

        if (tile != null) {
            tile.setLabel("Lightning");
            tile.setState(Tile.STATE_INACTIVE);
            tile.updateTile();
        }
    }

    @Override
    public void onClick() {
        super.onClick();

        if (!Shizuku.pingBinder()) {
            return;
        }

        if (Shizuku.checkSelfPermission()
                != PackageManager.PERMISSION_GRANTED) {
            return;
        }

        try {
            String[] command = {
                "sh",
                "-c",
                "service call activity_task 178"
            };

            Shizuku.newProcess(command, null, null);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

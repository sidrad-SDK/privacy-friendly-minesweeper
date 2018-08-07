/*
 This file is part of Privacy Friendly Minesweeper.

 Privacy Friendly Minesweeper is free software:
 you can redistribute it and/or modify it under the terms of the
 GNU General Public License as published by the Free Software Foundation,
 either version 3 of the License, or any later version.

 Privacy Friendly Minesweeper is distributed in the hope
 that it will be useful, but WITHOUT ANY WARRANTY; without even
 the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 See the GNU General Public License for more details.

 You should have received a copy of the GNU General Public License
 along with Privacy Friendly Minesweeper. If not, see <http://www.gnu.org/licenses/>.
 */

package org.secuso.privacyfriendlyminesweeper.activities.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.secuso.privacyfriendlyminesweeper.R;

import java.util.ArrayList;

/**
 * @author I3ananas
 * @version 20180802
 * This class implements an adapter to handle the items/views in a list of saved games
 * Saved games can be restarted from this list
 */
public class SavedGamesRecyclerViewAdapter extends RecyclerView.Adapter<SavedGamesRecyclerViewAdapter.ViewHolder> {

    private ArrayList<ArrayList<String>> savedGameParameters;

    //pass data to constructor
    public SavedGamesRecyclerViewAdapter(ArrayList<ArrayList<String>> parameters){
        this.savedGameParameters = parameters;
    }

    //fill text views with information about saved games
    @Override
    public void onBindViewHolder(@NonNull SavedGamesRecyclerViewAdapter.ViewHolder holder, int position) {
        if(savedGameParameters.get(position).size() > 0) {
            holder.id = Integer.valueOf(savedGameParameters.get(position).get(0));
            holder.savedGameMode.setText(savedGameParameters.get(position).get(1));
            holder.savedGamePlayingTime.setText(savedGameParameters.get(position).get(2));
            holder.savedGameDate.setText(savedGameParameters.get(position).get(3));
            holder.savedGameProgress.setProgress((int) (Math.round(Double.parseDouble(savedGameParameters.get(position).get(4)) * 100)));
        }
    }

    //get number of saved games
    @Override
    public int getItemCount(){
        return savedGameParameters.size();
    }

    //get list element for a single saved game
    public SavedGamesRecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        ViewGroup savedGame = (ViewGroup) LayoutInflater.from(parent.getContext()).inflate(R.layout.saved_game_list_element, parent, false);
        return new ViewHolder(savedGame);
    }

    //inner class for a list element representing a single saved game
    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public int id;
        public TextView savedGameMode;
        public TextView savedGameDate;
        public TextView savedGamePlayingTime;
        public ProgressBar savedGameProgress;

        //get text views to display information about saved games
        public ViewHolder(ViewGroup saved_game_list_element){
            super(saved_game_list_element);
            saved_game_list_element.setOnClickListener(this);

            this.savedGameMode = (TextView) ((RelativeLayout) saved_game_list_element.getChildAt(0)).getChildAt(0);
            this.savedGamePlayingTime = (TextView) ((RelativeLayout) saved_game_list_element.getChildAt(0)).getChildAt(1);
            this.savedGameDate = (TextView) ((RelativeLayout) saved_game_list_element.getChildAt(0)).getChildAt(2);
            this.savedGameProgress = (ProgressBar) ((RelativeLayout) saved_game_list_element.getChildAt(1)).getChildAt(0);
        }

        public void onClick(View view){
            //TODO: Start play activity as a restart, include variable 'this.id' e.g. as a parameter
            //TODO: In the started play activity create an instance of 'DatabaseSavedGameProvide' and call execute with the parameter 'this.id'
        }
    }

}

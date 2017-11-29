package com.tradexl.rxjavatest;

import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Raghav on 03-Nov-17.
 */

public class MyAdapter extends BaseAdapter {
    private List<InboxModel> gitHubRepos = new ArrayList<>();

    @Override public int getCount() {
        return gitHubRepos.size();
    }
    @Override public InboxModel getItem(int position) {
        if (position < 0 || position >= gitHubRepos.size()) {
            return null;
        } else {
            return gitHubRepos.get(position);
        }
    }
    @Override public long getItemId(int position) {
        return position;
    }

    @Override public View getView(int position, View convertView, ViewGroup parent) {
        final View view = (convertView != null ? convertView : createView(parent));
        final GitHubRepoViewHolder viewHolder = (GitHubRepoViewHolder) view.getTag();
        viewHolder.setGitHubRepo(getItem(position));
        return view;
    }

    private View createView(ViewGroup parent) {
        final LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        final View view = inflater.inflate(R.layout.item_github_repo, parent, false);
        final GitHubRepoViewHolder viewHolder = new GitHubRepoViewHolder(view);
        view.setTag(viewHolder);
        return view;
    }

    public void setGitHubRepos(List<InboxModel> inboxModels) {
        if (inboxModels == null) {
            return;
        }
        gitHubRepos.clear();
        gitHubRepos.addAll(inboxModels);
        notifyDataSetChanged();
    }

    private static class GitHubRepoViewHolder {
        private TextView textRepoDescription;
        private TextView textStars;

        public GitHubRepoViewHolder(View view) {
            textRepoDescription = (TextView) view.findViewById(R.id.text_repo_description);
            textStars = (TextView) view.findViewById(R.id.text_stars);
        }

        public void setGitHubRepo(InboxModel gitHubRepo) {
            textRepoDescription.setText(gitHubRepo.getMessage());
            textStars.setText("Stars: " + gitHubRepo.getIsImportant());
        }
    }
}
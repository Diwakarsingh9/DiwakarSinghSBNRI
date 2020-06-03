package com.test.diwakarsinghtest.pojo

class Model {


    var stargazers_count: String? = null
    var pushed_at: String? = null
    var subscription_url: String? = null
    var language: String? = null
    var branches_url: String? = null
    var issue_comment_url: String? = null
    var labels_url: String? = null
    var subscribers_url: String? = null
    var permissions: Permissions? = null
    var releases_url: String? = null
    var svn_url: String? = null
    var id: String? = null
    var forks: String? = null
    var archive_url: String? = null
    var git_refs_url: String? = null
    var forks_url: String? = null
    var statuses_url: String? = null
    var ssh_url: String? = null
    var expanded = false
    var license: License? = null
    var full_name: String? = null
    var size: String? = null
    var languages_url: String? = null
    var html_url: String? = null
    var collaborators_url: String? = null
    var clone_url: String? = null
    var name: String? = null
    var pulls_url: String? = null
    var default_branch: String? = null
    var hooks_url: String? = null
    var trees_url: String? = null
    var tags_url: String? = null
    var private: String? = null
    var contributors_url: String? = null
    var has_downloads: String? = null
    var notifications_url: String? = null
    var open_issues_count: String? = null
    var description: String? = null
    var created_at: String? = null
    var watchers: String? = null
    var keys_url: String? = null
    var deployments_url: String? = null
    var has_projects: String? = null
    var archived: String? = null
    var has_wiki: String? = null
    var updated_at: String? = null
    var comments_url: String? = null
    var stargazers_url: String? = null
    var disabled: String? = null
    var git_url: String? = null
    var has_pages: String? = null
    var owner: Owner? = null
    var commits_url: String? = null
    var compare_url: String? = null
    var git_commits_url: String? = null
    var blobs_url: String? = null
    var git_tags_url: String? = null
    var merges_url: String? = null
    var downloads_url: String? = null
    var has_issues: String? = null
    var url: String? = null
    var contents_url: String? = null
    private val mirror_url: String? = null
    var milestones_url: String? = null
    var teams_url: String? = null
    var fork: String? = null
    var issues_url: String? = null
    var events_url: String? = null
    var issue_events_url: String? = null
    var assignees_url: String? = null
    var open_issues: String? = null
    var watchers_count: String? = null
    var node_id: String? = null
    var homepage: String? = null
    var forks_count: String? = null



    fun getMirror_url(): String? {
        return milestones_url
    }

    fun setMirror_url(mirror_url: String?) {
        milestones_url = mirror_url
    }

    override fun toString(): String {
        return "ClassPojo [stargazers_count = $stargazers_count, pushed_at = $pushed_at, subscription_url = $subscription_url, language = $language, branches_url = $branches_url, issue_comment_url = $issue_comment_url, labels_url = $labels_url, subscribers_url = $subscribers_url, permissions = $permissions, releases_url = $releases_url, svn_url = $svn_url, id = $id, forks = $forks, archive_url = $archive_url, git_refs_url = $git_refs_url, forks_url = $forks_url, statuses_url = $statuses_url, ssh_url = $ssh_url, license = $license, full_name = $full_name, size = $size, languages_url = $languages_url, html_url = $html_url, collaborators_url = $collaborators_url, clone_url = $clone_url, name = $name, pulls_url = $pulls_url, default_branch = $default_branch, hooks_url = $hooks_url, trees_url = $trees_url, tags_url = $tags_url, private ="
        ", contributors_url = " + contributors_url + ", has_downloads = " + has_downloads + ", notifications_url = " + notifications_url + ", open_issues_count = " + open_issues_count + ", description = " + description + ", created_at = " + created_at + ", watchers = " + watchers + ", keys_url = " + keys_url + ", deployments_url = " + deployments_url + ", has_projects = " + has_projects + ", archived = " + archived + ", has_wiki = " + has_wiki + ", updated_at = " + updated_at + ", comments_url = " + comments_url + ", stargazers_url = " + stargazers_url + ", disabled = " + disabled + ", git_url = " + git_url + ", has_pages = " + has_pages + ", owner = " + owner + ", commits_url = " + commits_url + ", compare_url = " + compare_url + ", git_commits_url = " + git_commits_url + ", blobs_url = " + blobs_url + ", git_tags_url = " + git_tags_url + ", merges_url = " + merges_url + ", downloads_url = " + downloads_url + ", has_issues = " + has_issues + ", url = " + url + ", contents_url = " + contents_url + ", mirror_url = " + mirror_url + ", milestones_url = " + milestones_url + ", teams_url = " + teams_url + ", fork = " + fork + ", issues_url = " + issues_url + ", events_url = " + events_url + ", issue_events_url = " + issue_events_url + ", assignees_url = " + assignees_url + ", open_issues = " + open_issues + ", watchers_count = " + watchers_count + ", node_id = " + node_id + ", homepage = " + homepage + ", forks_count = " + forks_count + "]"
    }


}
package com.example.roomapi.hololive.api.model

import com.google.gson.annotations.SerializedName

data class HololiveResponse(

	@field:SerializedName("cached")
	val cached: Boolean? = null,

	@field:SerializedName("ended")
	val ended: List<EndedItem?>? = null,

	@field:SerializedName("live")
	val live: List<LiveItem?>? = null,

	@field:SerializedName("upcoming")
	val upcoming: List<UpcomingItem?>? = null
)

data class UpcomingItem(

	@field:SerializedName("bb_video_id")
	val bbVideoId: String? = null,

	@field:SerializedName("thumbnail")
	val thumbnail: String? = null,

	@field:SerializedName("live_viewers")
	val liveViewers: String? = null,

	@field:SerializedName("yt_video_key")
	val ytVideoKey: String? = null,

	@field:SerializedName("channel")
	val channel: Channel? = null,

	@field:SerializedName("live_schedule")
	val liveSchedule: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("live_start")
	val liveStart: String? = null,

	@field:SerializedName("title")
	val title: String? = null,

	@field:SerializedName("live_end")
	val liveEnd: String? = null
)

data class EndedItem(

	@field:SerializedName("bb_video_id")
	val bbVideoId: String? = null,

	@field:SerializedName("thumbnail")
	val thumbnail: String? = null,

	@field:SerializedName("live_viewers")
	val liveViewers: String? = null,

	@field:SerializedName("yt_video_key")
	val ytVideoKey: String? = null,

	@field:SerializedName("channel")
	val channel: Channel? = null,

	@field:SerializedName("live_schedule")
	val liveSchedule: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("live_start")
	val liveStart: String? = null,

	@field:SerializedName("title")
	val title: String? = null,

	@field:SerializedName("live_end")
	val liveEnd: String? = null
)

data class LiveItem(

	@field:SerializedName("bb_video_id")
	val bbVideoId: String? = null,

	@field:SerializedName("thumbnail")
	val thumbnail: String? = null,

	@field:SerializedName("live_viewers")
	val liveViewers: String? = null,

	@field:SerializedName("yt_video_key")
	val ytVideoKey: String? = null,

	@field:SerializedName("channel")
	val channel: Channel? = null,

	@field:SerializedName("live_schedule")
	val liveSchedule: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("live_start")
	val liveStart: String? = null,

	@field:SerializedName("title")
	val title: String? = null,

	@field:SerializedName("live_end")
	val liveEnd: String? = null
)

data class Channel(

	@field:SerializedName("twitter_link")
	val twitterLink: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("description")
	val description: String? = null,

	@field:SerializedName("photo")
	val photo: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("bb_space_id")
	val bbSpaceId: String? = null,

	@field:SerializedName("published_at")
	val publishedAt: String? = null,

	@field:SerializedName("yt_channel_id")
	val ytChannelId: String? = null
)

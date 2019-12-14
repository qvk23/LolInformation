package com.test.lolinformation.data.remote.api

const val BASE_URL = "https://api.pandascore.co"
const val PATH_CHAMPION = "/lol/champions"
const val PATH_ITEM = "/lol/items"
const val PATH_LEAGUE = "/lol/leagues"
const val PATH_MATCH = "/lol/matches"
const val PATH_SERIE = "/lol/series"
const val PATH_PARAM_SERIE_ID = "serie_id_or_slug"
const val PATH_PLAYER_FOR_SERIE = "/lol/series/{serie_id_or_slug}/players"
const val PATH_PLAYER = "/lol/players"
const val PATH_TEAM = "/lol/series/{serie_id_or_slug}/teams"

const val QUERY_PAGE = "page"
const val QUERY_PER_PAGE = "per_page"
const val QUERY_FILTER_NAME = "filter[name]"
const val QUERY_FILTER_SERIE_ID = "filter[serie_id]"
const val QUERY_FILTER_LEAGUE_ID = "filter[league_id]"
const val QUERY_FILTER_YEAR = "filter[year]"
const val QUERY_FILTER_TEAM_ID = "filter[team_id]"

const val LCK_LEAGUE_ID = 293
const val LPL_LEAGUE_ID = 294
const val LEC_LEAGUE_ID = 4197

const val DEFAULT_ITEM_PER_PAGE = 20
const val YEAR = 2019
const val CODE_TIMEOUT = -1
const val MESSAGE_TIMEOUT = "Request TimeOut"
const val CODE_BAD_REQUEST = 400
const val MESSAGE_BAD_REQUEST = "Bad Request"
const val CODE_UNAUTHORISED = 401
const val MESSAGE_UNAUTHORISED = "You are not authorized"
const val CODE_FORBIDDEN = 403
const val MESSAGE_FORBIDDEN = "Forbidden"
const val CODE_NOT_FOUND = 404
const val MESSAGE_NOT_FOUND = "Not Found"
const val CODE_UNPROCESSABLE_ENTITY = 422
const val MESSAGE_UNPROCESSABLE_ENTITY = "Unprocessable Entity"
const val MESSAGE_SOMETHING_ERROR = "Something went wrong"
